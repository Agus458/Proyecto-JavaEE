package beans;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import web_service.DataJuego;
import web_service.SteamIndie;
import web_service.SteamIndieImpPortBindingStub;
import web_service.SteamIndieImpService;
import web_service.SteamIndieImpServiceLocator;

@ManagedBean
@RequestScoped
public class IndexBean {
	
	private List<DataJuego> displayJuegos = new ArrayList<DataJuego>();

	
	public IndexBean() throws MalformedURLException, RemoteException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);		
		
		for(DataJuego j : ws.listarJuegos()) {
			displayJuegos.add(j);
		}
		
	}
	
	
	//=================
	//GETTERS & SETTERS
	//=================
	
	public List<DataJuego> getDisplayJuegos() {
		return displayJuegos;
	}

	public void setDisplayJuegos(List<DataJuego> displayJuegos) {
		this.displayJuegos = displayJuegos;
	}
	
	
	
}
