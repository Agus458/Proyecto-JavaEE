package beans;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import web_service.SteamIndie;
import web_service.SteamIndieImpPortBindingStub;
import web_service.SteamIndieImpService;
import web_service.SteamIndieImpServiceLocator;

@ManagedBean
@RequestScoped
public class Billetera implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Float saldo;
	private Float carga;
	
	@ManagedProperty(value="#{sesionBean}")
		private SesionBean session; 

		
	public String agregarSaldo() throws RemoteException, MalformedURLException{
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		ws.cargarBilleteraJugador(session.getUsuario().getId(), carga);
		
		return FacesContext.getCurrentInstance().getViewRoot().getViewId()+"?faces-redirect=true";
	}
	
	public Float getSaldo() throws MalformedURLException, RemoteException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		saldo = ws.darSaldoJugador(session.getUsuario().getId());
		return saldo;
	}
	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}
	public Float getCarga() {
		return carga;
	}
	public void setCarga(Float carga) {
		this.carga = carga;
	}

	public SesionBean getSession() {
		return session;
	}

	public void setSession(SesionBean session) {
		this.session = session;
	}
	
}
