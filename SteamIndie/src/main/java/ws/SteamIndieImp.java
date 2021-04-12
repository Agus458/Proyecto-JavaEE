/**
 * 
 */
package ws;

import javax.jws.WebService;

import controller.Fabric;
import controller.UsuarioControllerLocal;

/**
 * @author Agustín
 *
 */
@WebService(endpointInterface = "ws.SteamIndie")
public class SteamIndieImp implements SteamIndie{

	private UsuarioControllerLocal userController;
	
	/**
	 * 
	 */
	public SteamIndieImp() {
		this.userController = Fabric.getUsuarioController();
	}

	@Override
	public Boolean nickEnUso(String nick) {
		return userController.nickEnUso(nick);
	}

}
