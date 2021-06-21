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

import web_service.DataJuego;
import web_service.DataOferta;
import web_service.SteamIndie;
import web_service.SteamIndieImpPortBindingStub;
import web_service.SteamIndieImpService;
import web_service.SteamIndieImpServiceLocator;


@ManagedBean
@ViewScoped
public class SalesBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<DataOferta> ofertas = new ArrayList<DataOferta>();
	
	private Integer idOferta;
	private List<String> juegosElegidos = new ArrayList<String>();
	
	private List<DataJuego> juegosAgregar = new ArrayList<DataJuego>();

	private List<DataJuego> juegosQuitar = new ArrayList<DataJuego>();
	
	//Sesion
	@ManagedProperty(value="#{sesionBean}")
		private SesionBean session;
		
	
	public SalesBean() throws RemoteException, MalformedURLException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		
		DataOferta[] ofertaWS = ws.listarOfertasPendientes();
		
		if(ofertaWS!=null) {
			for(DataOferta o: ofertaWS) {
				ofertas.add(o);
			}
		}
	}
	
	public void agregarJuegoOferta() throws RemoteException, MalformedURLException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
				
		if(!juegosElegidos.isEmpty()) {
			Integer i = 0;
			int[] juegosArreglo = new int[juegosElegidos.size()];
			for(String juegoId: juegosElegidos) {
				juegosArreglo[i]=Integer.parseInt(juegoId);
				i++;
			}
			ws.agregarJuegoAOferta(idOferta, juegosArreglo);
		}
	}
	
	public void quitarJuegoOferta() throws RemoteException, MalformedURLException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		
		if(!juegosElegidos.isEmpty()) {
			Integer i = 0;
			int[] juegosArreglo = new int[juegosElegidos.size()];
			for(String juegoId: juegosElegidos) {
				juegosArreglo[i]=Integer.parseInt(juegoId);
				i++;
			}
			ws.quitarJuegoAOferta(idOferta, juegosArreglo);
		}
	}

	public void cambiarJuegosAgregar(Integer id) throws RemoteException, MalformedURLException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		
		DataJuego[] juegos = ws.darJuegosNoEnOferaCreador(id, session.getUsuario().getId());
		
		juegosAgregar = new ArrayList<DataJuego>();
		

		idOferta=id;
		
		if(juegos!=null) {
			for(DataJuego j: juegos) {
				juegosAgregar.add(j);
			}
		}
	}

	public void cambiarJuegosQuitar(Integer id) throws RemoteException, MalformedURLException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		
		DataJuego[] juegos = ws.darJuegosEnOferaCreador(id, session.getUsuario().getId());
		
		juegosQuitar = new ArrayList<DataJuego>();
		
		idOferta=id;
		
		if(juegos!=null) {
			for(DataJuego j: juegos) {
				juegosQuitar.add(j);
			}
		}
	}


	// GETTES & SETTERS
	
	public List<DataOferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<DataOferta> ofertas) {
		this.ofertas = ofertas;
	}

	public List<String> getJuegosElegidos() {
		return juegosElegidos;
	}

	public void setJuegosElegidos(List<String> juegosElegidos) {
		this.juegosElegidos = juegosElegidos;
	}

	public Integer getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(Integer idOferta) {
		this.idOferta = idOferta;
	}

	public List<DataJuego> getJuegosQuitar() {
		return juegosQuitar;
	}

	public void setJuegosQuitar(List<DataJuego> juegosQuitar) {
		this.juegosQuitar = juegosQuitar;
	}

	public List<DataJuego> getJuegosAgregar() {
		return juegosAgregar;
	}

	public void setJuegosAgregar(List<DataJuego> juegosAgregar) {
		this.juegosAgregar = juegosAgregar;
	}

	public SesionBean getSession() {
		return session;
	}

	public void setSession(SesionBean session) {
		this.session = session;
	}

	
	
}
