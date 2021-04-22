package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import data_types.DataCreador;
import data_types.DataJugador;
import data_types.DataUsuario;
import persistence.UsuarioDAO;
import persistence.UsuarioDAOImp;

/**
 * Session Bean implementation class ControllerUsuarioImp
 */
@Stateless
public class ControllerUsuarioImp implements ControllerUsuario {

	@EJB
	private UsuarioDAO usuarioPersistence = new UsuarioDAOImp();
	
    /**
     * Default constructor. 
     */
    public ControllerUsuarioImp() {
    	
    }
    
    @Override
    public Boolean emailEnUso(String email) {
    	return usuarioPersistence.buscarUsuarioEmail(email).getId() != null;
    }

	@Override
	public void registrarJugador(DataJugador jugador) {
		if(!emailEnUso(jugador.getEmail()) &&  !nickEnUso(jugador.getNickname())) {
			usuarioPersistence.insertarJugador(jugador);
		}
	}

	@Override
	public Boolean nickEnUso(String nick) {
		return usuarioPersistence.buscarUsuarioNick(nick).getId() != null;
	}

	@Override
	public List<DataUsuario> listarUsuarios() {
		return usuarioPersistence.listarUsuarios();
	}

	@Override
	public DataUsuario buscarUsuarioEmail(String email) {
		return usuarioPersistence.buscarUsuarioEmail(email);
	}

	@Override
	public DataUsuario buscarUsuarioNick(String nick) {
		return usuarioPersistence.buscarUsuarioNick(nick);
	}

	@Override
	public void registrarCreador(DataCreador creador) {
		if(!emailEnUso(creador.getEmail()) &&  !nickEnUso(creador.getNickname())) {
			usuarioPersistence.insertarCreador(creador);
		}
	}

	@Override
	public DataUsuario buscarUsuarioId(Integer id) {
		return usuarioPersistence.buscarUsuarioId(id);
	}

}
