package beans;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.axis.AxisFault;

import web_service.DataCreador;
import web_service.DataJugador;
import web_service.DataUsuario;
import web_service.SteamIndie;
import web_service.SteamIndieImpPortBindingStub;
import web_service.SteamIndieImpService;
import web_service.SteamIndieImpServiceLocator;

@ManagedBean
@RequestScoped
public class UserBean implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private String email="";
	private String pwd="";
	private String nick="";
	private String nombre="";
	private String apellido="";
	private Boolean creador;

	
	
	public String Registro() throws AxisFault, MalformedURLException{
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		
		try {
			if(!ws.emailEnUso(email)&&!ws.nickEnUso(nick)) {
				if(!this.creador)
					ws.registrarJugador(new DataJugador(null, nombre, apellido, email, pwd, nick));			
				else {
					ws.registrarCreador(new DataCreador(null, nombre, apellido, email, apellido, nick, null));
				}
			}else {
				FacesContext facesContext = FacesContext.getCurrentInstance();
				FacesMessage facesMessage = new FacesMessage("El Usuario ya existe");
				facesContext.addMessage(null, facesMessage);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "index";
		
	}
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	


	public Boolean getCreador() {
		return creador;
	}

	public void setCreador(Boolean creador) {
		this.creador = creador;
	}
}