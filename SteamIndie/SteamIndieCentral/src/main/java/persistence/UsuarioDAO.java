package persistence;

import java.util.List;

import javax.ejb.Local;

import data_types.DataJugador;
import data_types.DataUsuario;

@Local
public interface UsuarioDAO {

	public void insertarJugador(DataJugador jugador);
	
	public List<DataUsuario> listarUsuarios();
	
	public DataUsuario buscarUsuarioEmail(String email);
	
	public DataUsuario buscarUsuarioNick(String nick);
	
}
