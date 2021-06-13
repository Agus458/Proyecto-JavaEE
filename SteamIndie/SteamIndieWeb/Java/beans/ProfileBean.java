package beans;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import web_service.DataPagina;
import web_service.DataPost;
import web_service.SteamIndie;
import web_service.SteamIndieImpPortBindingStub;
import web_service.SteamIndieImpService;
import web_service.SteamIndieImpServiceLocator;
import web_service.TipoPost;

@ManagedBean
@RequestScoped
public class ProfileBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<DataPost> posts = new ArrayList<DataPost>();
	
	private Integer tipo;
	
	private String contenido;
	
	//Sesion
	@ManagedProperty(value="#{sesionBean}")
		private SesionBean session;

	private String texto;
		
	
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
	

	public List<DataPost> getPosts() throws RemoteException, MalformedURLException {
		if(posts.isEmpty()) {
			SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
			SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
			DataPagina page = ws.listarPost(session.getUsuario().getId(), 0);
			if(page!=null && page.getData()!=null) {
				for(Object o: page.getData()){
					
					posts.add((DataPost) o);
				}
			}
		}
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

	
}
