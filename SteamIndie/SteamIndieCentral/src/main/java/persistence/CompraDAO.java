package persistence;

import javax.ejb.Local;

import model.Compra;
import model.Juego;
import model.Jugador;

@Local
public interface CompraDAO {

	public void insertarComra(Jugador jugador, Juego juego);
	
	public Compra darCompraJugador(Integer idJugador, Integer idJuego);
	
}
