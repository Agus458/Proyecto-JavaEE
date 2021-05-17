/**
 * 
 */
package web_service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import data_types.DataCarrito;
import data_types.DataCategoria;
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
	public Boolean nombreJuegoEnUso(String nombreJuego);

	@WebMethod
	public List<DataJuego> listarJuegos();

	@WebMethod
	public DataJuego buscarJuegoId(Integer id);

	@WebMethod
	public DataJuego buscarJuegoNombre(String nombre);

	@WebMethod
	public DataCarrito darDatosCarritoJugador(Integer idJugador);

	@WebMethod
	public void agregarJuegoAlCarritoJugador(Integer idJugador, Integer idJuego);

	@WebMethod
	public void eliminarJuegoDelCarritoJugador(Integer idJugador, Integer idJuego);

	@WebMethod
	public void cargarBilleteraJugador(Integer idJugador, Float monto);

	@WebMethod
	public Float darSaldoJugador(Integer idJuagdor);

	@WebMethod
	public List<DataCategoria> listarCategorias();
	
	@WebMethod
	public void realizarCheckout(Integer idJugador);
	
	@WebMethod
	public DataCreador darDatosCreadorJuego(Integer idJuego);
	
	@WebMethod
	public List<DataJuego> darBibliotecaJugador(Integer idJugador);
	
	@WebMethod
	public void valorarJuego(Integer valoracion, Integer idJuego, Integer idJugador);

}
