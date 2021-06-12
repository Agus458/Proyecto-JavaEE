package controllers;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import data_types.DataOferta;

@Local
public interface ControllerOferta {

	public void crearOferta(String nombre, Date fechaInicio, Date fechaFin, Float descuento);
	
	public Boolean validarFechas(Date fechaInicio, Date fechaFin);
	
	public void agregarJuegosOferta(Integer idOferta, List<Integer> idJuegos);
	
	public void removerJuegosOferta(Integer idOferta, List<Integer> idJuegos);
	
	public List<DataOferta> darOfertasPendientes();
	
}
