package controllers;

import java.util.List;

import javax.ejb.Local;

import data_types.DataJuego;
import model.Juego;

@Local
public interface ControllerJuego {

	public void publicarJuego(DataJuego juego, Integer id);
	
	public Boolean nombreEnUso(String nombre);
	
	public List<DataJuego> listarJuegos();
	
	public DataJuego buscarJuegoId(Integer id);
	
	public DataJuego buscarJuegoNombre(String nombre);
	
	public Juego darJuego(Integer idJuego);
	
}
