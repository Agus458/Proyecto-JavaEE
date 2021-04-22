package persistence;

import java.util.List;

import javax.ejb.Local;

import data_types.DataCreador;
import data_types.DataJugador;
import data_types.DataUsuario;

@Local
public interface UsuarioDAO {

	public void insertarJugador(DataJugador jugador);
	
	public void insertarCreador(DataCreador creador);
	
	public List<DataUsuario> listarUsuarios();
	
	public DataUsuario buscarUsuarioEmail(String email);
	
	public DataUsuario buscarUsuarioNick(String nick);
	
	public DataUsuario buscarUsuarioId(Integer id);
	
}
