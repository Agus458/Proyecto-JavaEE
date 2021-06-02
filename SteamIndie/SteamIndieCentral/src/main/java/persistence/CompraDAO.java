package persistence;

import java.util.List;

import javax.ejb.Local;

import model.Compra;
import model.Detalle;
import model.Juego;
import model.Jugador;

@Local
public interface CompraDAO {

	public Compra insertarCompra(Jugador jugador, List<Juego> juegos);
	
	public Compra darCompraJugador(Integer idJugador, Integer idJuego);
	
	public List<Compra> darTodasCompras();
	
	public List<Juego> masVendidos();

	public List<Detalle> darTodosDetalles();
}
