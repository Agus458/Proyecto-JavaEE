package persistence;

import java.util.List;

import javax.ejb.Local;

import data_types.DataCreador;
import data_types.DataJugador;
import model.Creador;
import model.Jugador;

@Local
public interface UsuarioDAO {

	public Jugador insertarJugador(DataJugador jugador);

	public Creador insertarCreador(DataCreador creador);

	public List<Jugador> listarJugadores();

	public List<Creador> listarCreadores();

	public Jugador buscarJugadorEmail(String email);

	public Jugador buscarJugadorNick(String nick);

	public Jugador buscarJugadorId(Integer id);

	public Creador buscarCreadorEmail(String email);

	public Creador buscarCreadorNick(String nick);

	public Creador buscarCreadorId(Integer id);
	
	public void actualizarJugador(Jugador jugador);

}
