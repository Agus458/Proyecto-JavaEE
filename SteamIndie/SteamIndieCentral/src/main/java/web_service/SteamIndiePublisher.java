/**
 * 
 */
package web_service;

import javax.xml.ws.Endpoint;

/**
 * @author Agust�n
 *
 */
public class SteamIndiePublisher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:1515/SteamIndieWS", new SteamIndieImp());
	}

}
