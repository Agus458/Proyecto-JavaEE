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

import web_service.DataJuego;
import web_service.DataUsuario;
import web_service.SteamIndie;
import web_service.SteamIndieImpPortBindingStub;
import web_service.SteamIndieImpService;
import web_service.SteamIndieImpServiceLocator;

@ManagedBean
@RequestScoped
public class StatsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<DataJuego> masVendidos = new ArrayList<DataJuego>();
	private List<DataJuego> juegosBloqueados = new ArrayList<DataJuego>();

	private float ganancias = -1;
	
	// Sesion
	@ManagedProperty(value = "#{sesionBean}")
	private SesionBean session;

	public StatsBean() {}
	
	public void solicitarDesbloqueo(Integer idJuego) throws RemoteException, MalformedURLException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		
		ws.solicitarDesbloquearJuego(idJuego);
	}
	
	// GETTERS & SETTERS
	
	public List<DataJuego> getMasVendidos() throws RemoteException, MalformedURLException {
		if(masVendidos.isEmpty()) {
			SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
			SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
			DataUsuario usuario = session.getCreador();
			if(usuario!=null) {
				ganancias = ws.darVentasCreador(usuario.getId());
				if(ws.juegoMasVendidosCreador(usuario.getId())!=null) {
					for(DataJuego j :ws.juegoMasVendidosCreador(usuario.getId())) {
						masVendidos.add(j);
					}
				}
			}
			usuario = session.getAdmin();
			if(usuario!=null) {
				if(ws.juegoMasVendidos()!=null) {
					for(DataJuego j :ws.juegoMasVendidos()) {
						masVendidos.add(j);
					}
				}
			}
		}
		return masVendidos;
	}

	public void setMasVendidos(List<DataJuego> masVendidos) {
		this.masVendidos = masVendidos;
	}

	public float getGanancias() throws RemoteException, MalformedURLException {
		if(ganancias == -1) {
			SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
			SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
			DataUsuario usuario = session.getCreador();
			if(usuario!=null) {
				ganancias = ws.darVentasCreador(usuario.getId());		
			}
			usuario = session.getAdmin();
			if(usuario!=null) {
				ganancias = ws.darVentasTotal();
			}
		}
		return ganancias;
	}

	public void setGanancias(float ganancias) {
		this.ganancias = ganancias;
	}

	public SesionBean getSession() {
		return session;
	}

	public void setSession(SesionBean session) {
		this.session = session;
	}

	public Integer getCantVenta(Integer idJuego) throws RemoteException, MalformedURLException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		return ws.darCantVentasJuego(idJuego);
	}


	public List<DataJuego> getJuegosBloqueados() throws RemoteException, MalformedURLException {
		if(juegosBloqueados.isEmpty()) {
			SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
			SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
			DataUsuario usuario = session.getCreador();
			if(usuario!=null) {
				if(ws.darJuegosBloqueados(usuario.getId())!=null) {
					for(DataJuego j :ws.darJuegosBloqueados(usuario.getId())) {
						juegosBloqueados.add(j);
					}
				}
			}
		}
		return juegosBloqueados;
	}


	public void setJuegosBloqueados(List<DataJuego> juegosBloqueados) {
		this.juegosBloqueados = juegosBloqueados;
	}
	
}
