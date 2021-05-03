package beans;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


import web_service.DataCarrito;
import web_service.SteamIndie;
import web_service.SteamIndieImpPortBindingStub;
import web_service.SteamIndieImpService;
import web_service.SteamIndieImpServiceLocator;

@ManagedBean
@RequestScoped
public class CarritoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	DataCarrito carrito;
	Integer addId;

	@ManagedProperty(value="#{sesionBean}")
		private SesionBean session; 
	



	
	public void addCarrito() throws MalformedURLException, RemoteException{
		HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String idRequest = origRequest.getParameter("id");
		if(idRequest!=null) {
			SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
			SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);			
			ws.agregarJuegoAlCarritoJugador(session.getUsuario().getId(), Integer.parseInt(idRequest));
		}
		
	}
	
	public String removeCarrito(Integer id) throws MalformedURLException, RemoteException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		
		ws.eliminarJuegoDelCarritoJugador(session.getUsuario().getId(), id);
		
		return "/views/cart.xhtml";
	}
	
	public void checkOut() throws MalformedURLException, RemoteException{
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		
		ws.realizarCheckout(session.getUsuario().getId());
		
	}
	
	
	public SesionBean getSession() {
		return session;
	}



	public void setSession(SesionBean session) {
		this.session = session;
	}
	

	public DataCarrito getCarrito() throws MalformedURLException, RemoteException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		carrito = ws.darDatosCarritoJugador(session.getUsuario().getId());
		return carrito;
	}

	public void setCarrito(DataCarrito carrito) {
		this.carrito = carrito;
	}

	public Integer getAddId() {
		return addId;
	}

	public void setAddId(Integer addId) {
		this.addId = addId;
	}
	
	
	
}
