/**
 * 
 */
package web_service;

import java.util.List;

import javax.jws.WebService;

import controllers.ControllerUsuario;
import controllers.Fabric;
import data_types.DataCreador;
import data_types.DataJugador;
import data_types.DataUsuario;

/**
 * @author Agustín
 *
 */
@WebService(endpointInterface = "web_service.SteamIndie")
public class SteamIndieImp implements SteamIndie{
	
	/**
	 * Default Constructor
	 */
	public SteamIndieImp() {
		super();
	}

	@Override
	public void registrarJugador(DataJugador jugador) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		controller.registrarJugador(jugador);
	}

	@Override
	public List<DataUsuario> listarUsuarios() {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		return controller.listarUsuarios();
	}

	@Override
	public DataUsuario buscarUsuarioEmail(String email) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		return controller.buscarUsuarioEmail(email);
	}

	@Override
	public DataUsuario buscarUsuarioNick(String nick) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		return controller.buscarUsuarioNick(nick);
	}

	@Override
	public Boolean emailEnUso(String email) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		return controller.emailEnUso(email);
	}

	@Override
	public Boolean nickEnUso(String nick) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		return controller.nickEnUso(nick);
	}

	@Override
	public void registrarCreador(DataCreador creador) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		controller.registrarCreador(creador);
	}

	@Override
	public DataUsuario buscarUsuarioId(Integer id) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		return controller.buscarUsuarioId(id);
	}

}
