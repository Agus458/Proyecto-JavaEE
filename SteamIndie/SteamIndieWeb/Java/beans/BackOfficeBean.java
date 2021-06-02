package beans;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
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
	private Integer descuentoOferta;
	private Date fechaInicio;
	private Date fechaFin;
	
	private List<DataComentario> comentariosReportados = new ArrayList<DataComentario>();
	
	public BackOfficeBean() throws MalformedURLException, RemoteException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);		
		
		for(DataJuego j: ws.listarJuegos() ) {
			for(DataComentario c: ws.darUltimosComentariosJuego(j.getId())) {
				if(c.getReportado()) {
					comentariosReportados.add(c);
				}
			}
		}
	}

	public void agregarCategoria(){
		if(!categoria.isEmpty()) {
			categorias.add(new DataCategoria(null, categoria));
			categoria="";
		}
	}
	
	
	public void crearOferta() {
		//TODO
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getNombreOferta() {
		return nombreOferta;
	}

	public void setNombreOferta(String nombreOferta) {
		this.nombreOferta = nombreOferta;
	}

	public Integer getDescuentoOferta() {
		return descuentoOferta;
	}

	public void setDescuentoOferta(Integer descuentoOferta) {
		this.descuentoOferta = descuentoOferta;
	}

	public List<DataComentario> getComentariosReportados() {
		return comentariosReportados;
	}

	public void setComentariosReportados(List<DataComentario> comentariosReportados) {
		this.comentariosReportados = comentariosReportados;
	}

}
