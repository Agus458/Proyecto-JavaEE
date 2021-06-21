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
import web_service.SteamIndie;
import web_service.SteamIndieImpPortBindingStub;
import web_service.SteamIndieImpService;
import web_service.SteamIndieImpServiceLocator;

@ManagedBean
@ViewScoped
public class LibraryBean implements Serializable{

	private static final long serialVersionUID = 1L;

	//Atributos Bean
	private DataJuego juego = null;
	private List<DataJuego> biblioteca; 
	private Boolean bibliotecaVacia = true;
	
	//Inyeccion sesion
	@ManagedProperty(value = "#{sesionBean}")
		private SesionBean session;
	
	//Constructor
	public LibraryBean() {
		biblioteca = new ArrayList<DataJuego>();
	}
	
	//Juego display
	public void viewJuego(DataJuego viewJuego ){
		this.setJuego(viewJuego);
	}
	
	//Existe en lista
	public boolean tieneJuego(Integer id) throws RemoteException, MalformedURLException {
		for(DataJuego juego: getBiblioteca()) {
			if(juego.getId().equals(id)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	//===================//
	// GETTERS & SETTERS //
	//===================//
	
	
	public DataJuego getJuego() {
		return juego;
	}

	public void setJuego(DataJuego juego) {
		this.juego = juego;
	}

	public List<DataJuego> getBiblioteca() throws RemoteException, MalformedURLException {
		if(biblioteca.isEmpty()) {
			SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
			SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
			if(session.isActivo()) {
			DataJuego[] bibliotecaWS =  ws.darBibliotecaJugador(session.getUsuario().getId());
				if(bibliotecaWS!=null) {
					for(DataJuego j : bibliotecaWS ) {
						biblioteca.add(j);
					}
					bibliotecaVacia = false;
				}
			}
		}
		return biblioteca;
	}

	public void setBiblioteca(List<DataJuego> biblioteca) {
		this.biblioteca = biblioteca;
	}

	public SesionBean getSession() {
		return session;
	}

	public void setSession(SesionBean session) {
		this.session = session;
	}

	public Boolean getBibliotecaVacia() {
		return bibliotecaVacia;
	}

	public void setBibliotecaVacia(Boolean bibliotecaVacia) {
		this.bibliotecaVacia = bibliotecaVacia;
	}

	
	
}
