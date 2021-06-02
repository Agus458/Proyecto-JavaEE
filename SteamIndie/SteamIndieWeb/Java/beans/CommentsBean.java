package beans;

import java.io.IOException;
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

import web_service.DataComentario;
import web_service.SteamIndie;
import web_service.SteamIndieImpPortBindingStub;
import web_service.SteamIndieImpService;
import web_service.SteamIndieImpServiceLocator;

@ManagedBean
@ViewScoped
public class CommentsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<DataComentario> comments = new ArrayList<DataComentario>();
	
	private String comentario="";
	
	private String id = null;
	
	private String respuesta="";
	
	//Sesion
		@ManagedProperty(value="#{sesionBean}")
			private SesionBean session;
		
	
	public CommentsBean() throws NumberFormatException, RemoteException, MalformedURLException {

		HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();	
		id = origRequest.getParameter("id");
		

		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		
		
		if(id!=null) {
			DataComentario commentsWS[] = ws.darUltimosComentariosJuego(Integer.parseInt(id));
			if(commentsWS!=null){
				for(DataComentario s : commentsWS) {
					comments.add(s);
				}
			}
		}
	}

	public void agregarComentario(Integer idJuego) throws NumberFormatException, IOException {
		
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);		
		
		ws.comentarJuego(comentario, idJuego, session.getUsuario().getId());
		if(id!=null) {
			DataComentario commentsWS[] = ws.darUltimosComentariosJuego(Integer.parseInt(id));
			if(commentsWS!=null){
				comments = new ArrayList<DataComentario>();

				for(DataComentario s : commentsWS) {
					comments.add(s);
				}
			}
		}
		comentario="";
		
	}
	
	public void responderComentario(Integer idComentario) throws RemoteException, MalformedURLException {
		
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);		
		System.out.println(respuesta);
		ws.responderComentario(idComentario, respuesta ,session.getUsuario().getId());
		
	}
	
	public void reportarComentario(Integer idComentario) throws NumberFormatException, RemoteException, MalformedURLException {
		
		
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);		
		
		ws.reportarComentario(idComentario);	
	}
	
	public List<DataComentario> getComments() {
		return comments;
	}

	public void setComments(List<DataComentario> comments) {
		this.comments = comments;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public SesionBean getSession() {
		return session;
	}

	public void setSession(SesionBean session) {
		this.session = session;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	
	

}
