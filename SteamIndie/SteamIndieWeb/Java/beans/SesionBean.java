package beans;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.axis.AxisFault;

import web_service.DataAdmin;
import web_service.DataCreador;
import web_service.DataUsuario;
import web_service.SteamIndie;
import web_service.SteamIndieImpPortBindingStub;
import web_service.SteamIndieImpService;
import web_service.SteamIndieImpServiceLocator;


@ManagedBean
@SessionScoped
public class SesionBean implements Serializable {
	
	//Atributos Sesion
	private static final long serialVersionUID = 1L;
	private String email;
	private String pwd;
	private boolean activo = false;
	private DataUsuario usuario;

	//Login & Logout
	public String Login() throws AxisFault, MalformedURLException {
		String res ="index.xhtml?faces-redirect=true";
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		
		try {
			DataUsuario usuario = ws.buscarUsuarioEmail(this.email);
			if(usuario!=null&&this.email.equals(usuario.getEmail())&&this.pwd.equals(usuario.getPassword())){
				this.usuario=usuario;
				this.activo=true;
				HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
				session.setAttribute("usuario", this.usuario);
			}
			else {
				 FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
				 
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return res;
		
	}
	

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		this.activo=false;
		return "/index.xhtml?faces-redirect=true";
	}
	
	
	//Diferentes Usuarios
	public DataCreador getCreador() {
		DataCreador res = null;
		try {
			res = (DataCreador) this.usuario;
		}
		catch (Exception e) {
		}
		return res;
	}

	public DataAdmin getAdmin() {
		DataAdmin res = null;
		try {
			res = (DataAdmin) this.usuario;
		}
		catch (Exception e) {
		}
		
		return res;
	}
	


	
	
	public DataUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(DataUsuario usuario) {
		this.usuario = usuario;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
		

	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
