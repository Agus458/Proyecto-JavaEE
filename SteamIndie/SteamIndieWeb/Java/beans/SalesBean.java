package beans;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import web_service.DataOferta;
import web_service.SteamIndie;
import web_service.SteamIndieImpPortBindingStub;
import web_service.SteamIndieImpService;
import web_service.SteamIndieImpServiceLocator;


@ManagedBean
@RequestScoped
public class SalesBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<DataOferta> ofertas = new ArrayList<DataOferta>();
	
	private Integer idOferta;
	private List<String> juegosElegidos = new ArrayList<String>();
	
	
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

	
	
}
