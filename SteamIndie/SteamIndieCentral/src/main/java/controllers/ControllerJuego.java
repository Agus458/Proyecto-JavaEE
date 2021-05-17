package controllers;

import java.util.List;

import javax.ejb.Local;

import data_types.DataCategoria;
import data_types.DataCreador;
import data_types.DataJuego;
import data_types.DataValoracion;
import model.Juego;

@Local
public interface ControllerJuego {

	public void publicarJuego(DataJuego juego, Integer id);
	
	public Boolean nombreJuegoEnUso(String nombreJuego);
	
	public List<DataJuego> listarJuegos();
	
	public DataJuego buscarJuegoId(Integer id);
	
	public DataJuego buscarJuegoNombre(String nombre);
	
	public Juego darJuego(Integer idJuego);
	
	public List<DataCategoria> listarCategorias();
	
	public DataCreador darDatosCreadorJuego(Integer idJuego);
	
	public void valorarJuego(Integer valoracion, Integer idJuego, Integer idJugador);
}
