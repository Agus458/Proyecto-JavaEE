/**
 * 
 */
package sistem;

import controller.UsuarioController;
import controller.UsuarioControllerLocal;

/**
 * @author Agust�n
 *
 */
public class Fabric {
	
	public static UsuarioControllerLocal getUsuarioController() {
		return new UsuarioController();
	}
	
}
