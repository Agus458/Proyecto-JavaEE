package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import web_service.DataCategoria;

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
	
	public BackOfficeBean() {
		// TODO Auto-generated constructor stub
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

}
