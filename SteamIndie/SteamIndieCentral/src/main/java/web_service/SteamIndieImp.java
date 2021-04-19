/**
 * 
 */
package web_service;

import java.util.List;

import javax.jws.WebService;

import controllers.ControllerUsuario;
import controllers.Fabric;
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
	public Boolean validarRegistro(String email, String nick) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		return controller.validarRegistro(email, nick);
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

}
