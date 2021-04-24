/**
 * 
 */
package web_service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import data_types.DataCreador;
import data_types.DataJuego;
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
	public void registrarCreador(DataCreador creador);

	@WebMethod
	public List<DataUsuario> listarUsuarios();

	@WebMethod
	public DataUsuario buscarUsuarioEmail(String email);

	@WebMethod
	public DataUsuario buscarUsuarioNick(String nick);

	@WebMethod
	public DataUsuario buscarUsuarioId(Integer id);

	@WebMethod
	public Boolean emailEnUso(String email);

	@WebMethod
	public Boolean nickEnUso(String nick);

	@WebMethod
	public void publicarJuego(DataJuego juego, Integer id);

	@WebMethod
	public Boolean nombreEnUso(String nombre);

	@WebMethod
	public List<DataJuego> listarJuegos();

	@WebMethod
	public DataJuego buscarJuegoId(Integer id);

	@WebMethod
	public DataJuego buscarJuegoNombre(String nombre);

}
