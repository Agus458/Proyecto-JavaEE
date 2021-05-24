package persistence;

import java.util.List;

import javax.ejb.Local;

import model.Comentario;
import model.Juego;
import model.Jugador;
import model.Valoracion;

@Local
public interface ReseniaDAO {

	public Valoracion insertarValoracion(Integer valoracion, Juego juego, Jugador jugador);
	
	public Valoracion actualizarValoracion(Valoracion valoracion , Integer val);
	
	public Comentario insertarComentario(String contenido, Juego juego, Jugador jugador);
	
	public Comentario actualizarComentario(Comentario comentario);
	
	public Comentario buscarComentarioId(Integer idComentario);
	
	public List<Comentario> darUltimosComentariosJuego(Integer idJuego);
	
}
