package beans;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import web_service.DataCategoria;
import web_service.DataComentario;
import web_service.DataJuego;
import web_service.SteamIndie;
import web_service.SteamIndieImpPortBindingStub;
import web_service.SteamIndieImpService;
import web_service.SteamIndieImpServiceLocator;

@ManagedBean
@ViewScoped
public class BackOfficeBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private String categoria="";
	private List<DataCategoria> categorias = new ArrayList<DataCategoria>();
	private List<String> categoriasAlojadas = new ArrayList<String>();
	
	private String nombreOferta;
	private float descuentoOferta;
	private String fechaInicio;
	private String fechaFin;
	
	private List<DataComentario> comentariosReportados = new ArrayList<DataComentario>();
	private List<DataJuego> juegosReportados = new ArrayList<DataJuego>();
	private List<DataJuego> juegosSolicitados = new ArrayList<DataJuego>();
	
	public BackOfficeBean() throws MalformedURLException, RemoteException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);		
		
		if(ws.darComentariosReportados()!=null) {
			for(DataComentario c: ws.darComentariosReportados()) {
				comentariosReportados.add(c);
			}
		}
		
		if(ws.darJuegosReportados()!=null) {
			for(DataJuego j: ws.darJuegosReportados()) {
				juegosReportados.add(j);
			}
		}
		
		if(ws.darJuegosSolicitados()!=null) {
			for(DataJuego j: ws.darJuegosSolicitados()) {
				juegosSolicitados.add(j);
			}
		}
		
	}

	public void agregarCategoria(){
		if(!categoria.isEmpty()) {
			categorias.add(new DataCategoria(null, categoria));
			categoria="";
		}
	}
	
	public void confirmarCategorias() throws RemoteException, MalformedURLException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);		
		
		for(DataCategoria c: categorias) {
			ws.agregarCategoria(c.getNombre());
		}
	}
	
	public void crearOferta() throws MalformedURLException, RemoteException, ParseException{
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);		
		
		String fInicio= fechaInicio.substring(0,10)+' '+fechaInicio.substring(11);

		String fFin=  fechaFin.substring(0,10)+' '+fechaFin.substring(11);
		
		ws.crearOferta(nombreOferta, toCalendar(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(fInicio)), toCalendar(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(fFin)), descuentoOferta);
	}
	
	public String borrarComentario(Integer idComentario) throws RemoteException, MalformedURLException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);		
		
		ws.bloquearComentario(idComentario);
		
		return "/backoffice/backoffice.xhtml";
	}
	
	public String bloquearJuego(Integer idJuego) throws RemoteException, MalformedURLException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);		
		
		ws.bloquearJuego(idJuego);
		
		return "/backoffice/backoffice.xhtml";
	}
	
	public String desbloquearJuego(Integer idJuego) throws RemoteException, MalformedURLException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);		
		
		ws.desbloquearJuego(idJuego);
		
		return "/backoffice/backoffice.xhtml";
	}
	
	//Funciones auxliares
	public static Calendar toCalendar(Date date){ 
	  Calendar cal = Calendar.getInstance();
	  cal.setTime(date);
	  return cal;
	}
	
	//
	//	GETTERS & SETTERS
	//
	

	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public List<DataCategoria> getCategorias() {
		return categorias;
	}



	public void setCategorias(List<DataCategoria> categorias) {
		this.categorias = categorias;
	}



	public List<String> getCategoriasAlojadas() {
		return categoriasAlojadas;
	}



	public void setCategoriasAlojadas(List<String> categoriasAlojadas) {
		this.categoriasAlojadas = categoriasAlojadas;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getNombreOferta() {
		return nombreOferta;
	}

	public void setNombreOferta(String nombreOferta) {
		this.nombreOferta = nombreOferta;
	}

	public float getDescuentoOferta() {
		return descuentoOferta;
	}

	public void setDescuentoOferta(float descuentoOferta) {
		this.descuentoOferta = descuentoOferta;
	}

	public List<DataComentario> getComentariosReportados() {
		return comentariosReportados;
	}

	public void setComentariosReportados(List<DataComentario> comentariosReportados) {
		this.comentariosReportados = comentariosReportados;
	}

	public List<DataJuego> getJuegosReportados() {
		return juegosReportados;
	}

	public void setJuegosReportados(List<DataJuego> juegosReportados) {
		this.juegosReportados = juegosReportados;
	}

	public List<DataJuego> getJuegosSolicitados() {
		return juegosSolicitados;
	}

	public void setJuegosSolicitados(List<DataJuego> juegosSolicitados) {
		this.juegosSolicitados = juegosSolicitados;
	}

	
}
