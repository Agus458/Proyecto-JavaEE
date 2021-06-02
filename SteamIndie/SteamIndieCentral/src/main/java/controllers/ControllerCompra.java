package controllers;

import java.util.List;

import javax.ejb.Local;

import data_types.DataJuego;


@Local
public interface ControllerCompra {

	public void realizarCheckout(Integer idJugador);
	
	public float darVentasTotales();
	
	public List<DataJuego> juegosMasVendidos();

	public List<DataJuego> juegosMasVendidos(Integer idCreador);

	public float darVentasTotalCreador(Integer idCreador);
	
	public Integer darCantVentasJuego(Integer idJuego);

	public Integer darCantVentasCreador(Integer idCreador);
}
