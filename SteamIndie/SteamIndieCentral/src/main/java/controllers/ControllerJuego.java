package controllers;

import java.util.List;

import javax.ejb.Local;

import data_types.DataCategoria;
import data_types.DataComentario;
import data_types.DataCreador;
import data_types.DataJuego;
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
	
	public void comentarJuego(String contenido, Integer idJuego, Integer idJugador);
	
	public void responderComentario(Integer idComentario, String contenido, Integer idJugador);
	
	public void reportarComentario(Integer idComentario);
	
	public List<DataComentario> darUltimosComentariosJuego(Integer idJuego);
}
