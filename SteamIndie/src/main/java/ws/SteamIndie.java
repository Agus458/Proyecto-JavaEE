/**
 * 
 */
package ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author Agustín
 *
 */
@WebService
public interface SteamIndie {

	@WebMethod
	public Boolean nickEnUso(String nick);
	
}
