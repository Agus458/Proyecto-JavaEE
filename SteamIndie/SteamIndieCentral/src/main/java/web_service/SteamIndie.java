/**
 * 
 */
package web_service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import data_types.DataJugador;
import data_types.DataUsuario;

/**
 * @author Agustín
 *
 */
@WebService
public interface SteamIndie {

	@WebMethod
	public void registrarJugador(DataJugador jugador);

	@WebMethod
	public Boolean validarRegistro(String email, String nick);
	
	@WebMethod
	public List<DataUsuario> listarUsuarios();
	
	@WebMethod
	public DataUsuario buscarUsuarioEmail(String email);
	
	@WebMethod
	public DataUsuario buscarUsuarioNick(String nick);

}
