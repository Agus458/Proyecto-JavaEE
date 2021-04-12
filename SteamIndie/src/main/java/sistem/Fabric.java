/**
 * 
 */
package sistem;

import controller.UsuarioController;
import controller.UsuarioControllerLocal;

/**
 * @author Agustín
 *
 */
public class Fabric {
	
	public static UsuarioControllerLocal getUsuarioController() {
		return new UsuarioController();
	}
	
}
