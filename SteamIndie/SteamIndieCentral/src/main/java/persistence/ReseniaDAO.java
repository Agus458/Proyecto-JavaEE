package persistence;

import javax.ejb.Local;

import model.Juego;
import model.Jugador;
import model.Valoracion;

@Local
public interface ReseniaDAO {

	public Valoracion insertarValoracion(Integer valoracion, Juego juego, Jugador jugador);
	
	public Valoracion actualizarValoracion(Valoracion valoracion , Integer val);
	
}
