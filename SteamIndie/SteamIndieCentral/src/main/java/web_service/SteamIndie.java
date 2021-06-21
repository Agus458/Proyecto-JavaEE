/**
 * 
 */
package web_service;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import data_types.DataAdmin;
import data_types.DataCarrito;
import data_types.DataCategoria;
import data_types.DataComentario;
import data_types.DataCreador;
import data_types.DataJuego;
import data_types.DataJugador;
import data_types.DataOferta;
import data_types.DataPagina;
import data_types.DataTag;
import data_types.DataUsuario;
import enums.TipoPost;

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
	public void registrarAdmin(DataAdmin admin);

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

	@WebMethod
	public void comentarJuego(String contenido, Integer idJuego, Integer idJugador);

	@WebMethod
	public void responderComentario(Integer idComentario, String contenido, Integer idJugador);

	@WebMethod
	public void reportarComentario(Integer idComentario);

	@WebMethod
	public List<DataComentario> darUltimosComentariosJuego(Integer idJuego);

	@WebMethod
	public float darVentasTotal();

	@WebMethod
	public List<DataJuego> juegoMasVendidos();

	@WebMethod
	public List<DataJuego> juegoMasVendidosCreador(Integer idCreador);

	@WebMethod
	public float darVentasCreador(Integer idCreador);

	@WebMethod
	public Integer darCantVentasCreador(Integer idCreador);

	@WebMethod
	public Integer darCantVentasJuego(Integer idJuego);

	@WebMethod
	public void agregarCategoria(String nombre);

	@WebMethod
	public void crearOferta(String nombre, Date fechaInicio, Date fechaFin, float descuento);

	@WebMethod
	public List<DataOferta> listarOfertasPendientes();

	@WebMethod
	public void agregarJuegoAOferta(Integer idOferta, List<Integer> idJuegos);

	@WebMethod
	public void quitarJuegoAOferta(Integer idOferta, List<Integer> idJuegos);

	@WebMethod
	public void publicarPost(TipoPost tipo, String contenido, String texto, Integer idJugador);

	@WebMethod
	public List<DataComentario> darComentariosReportados();

	@WebMethod
	public List<DataJuego> buscarJuegos(String nombre);

	@WebMethod
	public List<DataOferta> listarOfertas();

	@WebMethod
	public DataPagina listarPost(Integer idJugador, Integer pagina);

	@WebMethod
	public void bloquearComentario(Integer idComentario);

	@WebMethod
	public void reportarJuego(Integer idJuego);

	@WebMethod
	public void bloquearJuego(Integer idJuego);

	@WebMethod
	public List<DataJuego> darJuegosReportados();

	@WebMethod
	public void solicitarDesbloquearJuego(Integer idJuego);

	@WebMethod
	public void desbloquearJuego(Integer idJuego);

	@WebMethod
	public List<DataJuego> darJuegosBloqueados(Integer idCreador);

	@WebMethod
	public List<DataJuego> darJuegosSolicitados();

	@WebMethod
	public List<DataJugador> listarJugadores();

	@WebMethod
	public List<DataJuego> darJuegosEnOferaCreador(Integer idOferta, Integer idCreador);

	@WebMethod
	public List<DataJuego> darJuegosNoEnOferaCreador(Integer idOferta, Integer idCreador);

	@WebMethod
	public List<DataTag> listarTags();

}
