package beans;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import web_service.DataPagina;
import web_service.DataPost;
import web_service.DataUsuario;
import web_service.SteamIndie;
import web_service.SteamIndieImpPortBindingStub;
import web_service.SteamIndieImpService;
import web_service.SteamIndieImpServiceLocator;
import web_service.TipoPost;

@ManagedBean
@ViewScoped
public class ProfileBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<DataPost> posts = new ArrayList<DataPost>();
	
	private Integer tipo;
	
	private String contenido;
	
	//Sesion
	@ManagedProperty(value="#{sesionBean}")
		private SesionBean session;

	private String texto;
	
	private DataUsuario user = new DataUsuario();
	
	private Integer currentPage = 1;
	
	private String id;
	
	public ProfileBean() {

	}
	
	
	public void publicarPost() throws MalformedURLException, RemoteException{
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		
		TipoPost tipoP = null;
		switch (tipo) {
		case 1:
			tipoP =TipoPost.TEXTO;
			break;
		case 2:
			tipoP =TipoPost.IMAGEN;
			break;
		case 3:
			tipoP =TipoPost.VIDEO;
			break;

		default:
			break;
		}
		
		ws.publicarPost(tipoP, contenido, texto, session.getUsuario().getId());
	}
	
	
	
//	===================================
//			GETTERS & SETTERS
//	===================================
	

	public DataUsuario getUser() throws NumberFormatException, RemoteException, MalformedURLException {
		HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();	
		String idRequest = origRequest.getParameter("id");
		
		if(idRequest!=null) {
			id = idRequest;
		}
		
		user = session.getUsuario();
		
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		
		if(id!=null){
			
			user = ws.buscarUsuarioId(Integer.parseInt(id));
		}
		
		if(posts.isEmpty()) {			
			DataPagina page = ws.listarPost(user.getId(),1);
			if(page!=null && page.getData()!=null) {
				for(Object o: page.getData()){
					posts.add((DataPost) o);
				}
			}
		}
		return user;
	}
	
	public void cambiarPagina(Integer pagina) throws RemoteException, MalformedURLException {
		List<DataPost> res = new ArrayList<DataPost>();
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		
		
		DataPagina page = ws.listarPost(user.getId(), pagina);
		if(page!=null && page.getData()!=null) {
			for(Object o: page.getData()){
				res.add((DataPost) o);
			}
			setCurrentPage(pagina);
			posts = res;
		}
		
		
		
	}
	
	public List<DataPost> getPosts() throws RemoteException, MalformedURLException {
		return posts;
	}

	public void setPosts(List<DataPost> posts) {
		this.posts = posts;
	}

	public SesionBean getSession() {
		return session;
	}

	public void setSession(SesionBean session) {
		this.session = session;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setUser(DataUsuario user) {
		this.user = user;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	
}
