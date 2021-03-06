package beans;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import web_service.DataCategoria;
import web_service.DataJuego;
import web_service.SteamIndie;
import web_service.SteamIndieImpPortBindingStub;
import web_service.SteamIndieImpService;
import web_service.SteamIndieImpServiceLocator;

@ManagedBean
@ViewScoped
public class IndexBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//Display
	private List<DataJuego> displayJuegos = new ArrayList<DataJuego>();
	private List<DataJuego> carrouselJuegos = new ArrayList<DataJuego>();
	private DataJuego activo = new DataJuego();
	private List<DataJuego> restoJuegos = new ArrayList<DataJuego>();

	//Juegos
	private List<DataJuego> juegos = new ArrayList<DataJuego>();
	
	
	//Busqueda
	private String query="";
	private String categoria="";
	private	List<DataCategoria> categoriasDisponibles = new ArrayList<DataCategoria>();
	
	public IndexBean() throws MalformedURLException, RemoteException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);		
		Integer i = 0;
		if(ws.listarCategorias()!=null) {//TODO No devolver listas nulas
		for(DataCategoria c : ws.listarCategorias()) {
			categoriasDisponibles.add(c);
			
		}
		}
		i=0;
		if(ws.listarJuegos()!=null) {
		for(DataJuego j : ws.listarJuegos()){
			switch (i) {
			case 0:
				activo = j;
				break;
			case 1:
				carrouselJuegos.add(j);
				break;
			case 2:
				carrouselJuegos.add(j);
				break;				
			default:				
				restoJuegos.add(j);
				break;
			}
			i++;
			juegos.add(j);
			displayJuegos.add(j);
		}
		}
	}	
	
	public void aplicarFiltros() throws RemoteException, MalformedURLException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);	
		
		
		List<DataJuego> queryRes = new ArrayList<DataJuego>();
		List<DataJuego> res = new ArrayList<DataJuego>();

		if(!query.isEmpty()) {
			for(DataJuego j : ws.buscarJuegos(query)){
				queryRes.add(j);		
			}	
		}
		else {
			queryRes = juegos;
		}
		
		if(!categoria.isEmpty()) {
			for(DataJuego j: queryRes) {
				if(j.getCategorias()!=null) {
					for(DataCategoria c: j.getCategorias()) {
						if(c.getNombre().equals(categoria)) {
							res.add(j);
							break;
						}
					}
				}
			}
		}
		else {
			res = queryRes;
		}
		displayJuegos = res;
	}
	
	public DataJuego getJuego(Integer id) throws MalformedURLException, RemoteException {
		DataJuego res = null;
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);		
		res = ws.buscarJuegoId(id);
		return res;
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

	public List<DataJuego> getCarrouselJuegos() {
		return carrouselJuegos;
	}

	public void setCarrouselJuegos(List<DataJuego> carrouselJuegos) {
		this.carrouselJuegos = carrouselJuegos;
	}

	public DataJuego getActivo() {
		return activo;
	}

	public void setActivo(DataJuego activo) {
		this.activo = activo;
	}

	public List<DataJuego> getRestoJuegos() {
		return restoJuegos;
	}

	public void setRestoJuegos(List<DataJuego> restoJuegos) {
		this.restoJuegos = restoJuegos;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<DataCategoria> getCategoriasDisponibles() {
		return categoriasDisponibles;
	}

	public void setCategoriasDisponibles(List<DataCategoria> categoriasDisponibles) {
		this.categoriasDisponibles = categoriasDisponibles;
	}	
	
}
