/**
 * 
 */
package web_service;

import java.util.List;

import javax.jws.WebService;

import controllers.ControllerCompra;
import controllers.ControllerJuego;
import controllers.ControllerUsuario;
import controllers.Fabric;
import data_types.DataAdmin;
import data_types.DataCarrito;
import data_types.DataCategoria;
import data_types.DataComentario;
import data_types.DataCreador;
import data_types.DataJuego;
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

	@Override
	public Boolean emailEnUso(String email) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		return controller.emailEnUso(email);
	}

	@Override
	public Boolean nickEnUso(String nick) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		return controller.nickEnUso(nick);
	}

	@Override
	public void registrarCreador(DataCreador creador) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		controller.registrarCreador(creador);
	}

	@Override
	public DataUsuario buscarUsuarioId(Integer id) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		return controller.buscarUsuarioId(id);
	}

	@Override
	public void publicarJuego(DataJuego juego, Integer id) {
		ControllerJuego controller = Fabric.getControllerJuego();
		controller.publicarJuego(juego, id);
	}

	@Override
	public Boolean nombreJuegoEnUso(String nombreJuego) {
		ControllerJuego controller = Fabric.getControllerJuego();
		return controller.nombreJuegoEnUso(nombreJuego);
	}

	@Override
	public List<DataJuego> listarJuegos() {
		ControllerJuego controller = Fabric.getControllerJuego();
		return controller.listarJuegos();
	}

	@Override
	public DataJuego buscarJuegoId(Integer id) {
		ControllerJuego controller = Fabric.getControllerJuego();
		return controller.buscarJuegoId(id);
	}

	@Override
	public DataJuego buscarJuegoNombre(String nombre) {
		ControllerJuego controller = Fabric.getControllerJuego();
		return controller.buscarJuegoNombre(nombre);
	}

	@Override
	public DataCarrito darDatosCarritoJugador(Integer idJugador) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		return controller.darDatosCarritoJugador(idJugador);
	}

	@Override
	public void agregarJuegoAlCarritoJugador(Integer idJugador, Integer idJuego) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		controller.agregarJuegoAlCarritoJugador(idJugador, idJuego);
	}

	@Override
	public void eliminarJuegoDelCarritoJugador(Integer idJugador, Integer idJuego) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		controller.eliminarJuegoDelCarritoJugador(idJugador, idJuego);
	}

	@Override
	public void cargarBilleteraJugador(Integer idJugador, Float monto) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		controller.cargarBilleteraJugador(idJugador, monto);
	}

	@Override
	public Float darSaldoJugador(Integer idJuagdor) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		return controller.darSaldoJugador(idJuagdor);
	}

	@Override
	public List<DataCategoria> listarCategorias() {
		ControllerJuego controller = Fabric.getControllerJuego();
		return controller.listarCategorias();
	}

	@Override
	public void realizarCheckout(Integer idJugador) {
		ControllerCompra controller = Fabric.getControllerCompra();
		controller.realizarCheckout(idJugador);
	}

	@Override
	public DataCreador darDatosCreadorJuego(Integer idJuego) {
		ControllerJuego controller = Fabric.getControllerJuego();
		return controller.darDatosCreadorJuego(idJuego);
	}

	@Override
	public List<DataJuego> darBibliotecaJugador(Integer idJugador) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		return controller.darBibliotecaJugador(idJugador);
	}

	@Override
	public void valorarJuego(Integer valoracion, Integer idJuego, Integer idJugador) {
		ControllerJuego controller = Fabric.getControllerJuego();
		controller.valorarJuego(valoracion, idJuego, idJugador);
	}

	@Override
	public void comentarJuego(String contenido, Integer idJuego, Integer idJugador) {
		ControllerJuego controller = Fabric.getControllerJuego();
		controller.comentarJuego(contenido, idJuego, idJugador);
	}

	@Override
	public void responderComentario(Integer idComentario, String contenido, Integer idJugador) {
		ControllerJuego controller = Fabric.getControllerJuego();
		controller.responderComentario(idComentario, contenido, idJugador);
	}

	@Override
	public void reportarComentario(Integer idComentario) {
		ControllerJuego controller = Fabric.getControllerJuego();
		controller.reportarComentario(idComentario);
	}

	@Override
	public List<DataComentario> darUltimosComentariosJuego(Integer idJuego) {
		ControllerJuego controller = Fabric.getControllerJuego();
		return controller.darUltimosComentariosJuego(idJuego);
	}

	@Override
	public void registrarAdmin(DataAdmin admin) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		controller.registrarAdmin(admin);
	}

}
