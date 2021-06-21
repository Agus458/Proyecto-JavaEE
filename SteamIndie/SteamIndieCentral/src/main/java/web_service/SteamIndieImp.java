/**
 * 
 */
package web_service;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import controllers.ControllerCompra;
import controllers.ControllerJuego;
import controllers.ControllerOferta;
import controllers.ControllerUsuario;
import controllers.Fabric;
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

	@Override
	public float darVentasTotal() {
		ControllerCompra controller = Fabric.getControllerCompra();
		return controller.darVentasTotales();
	}
	
	@Override
	public float darVentasCreador(Integer idCreador) {
		ControllerCompra controller = Fabric.getControllerCompra();
		return controller.darVentasTotalCreador(idCreador);
	}
	
	@Override
	public List<DataJuego> juegoMasVendidos() {
		ControllerCompra controller = Fabric.getControllerCompra();
		return controller.juegosMasVendidos();
	}
	
	@Override
	public List<DataJuego> juegoMasVendidosCreador(Integer idCreador) {
		ControllerCompra controller = Fabric.getControllerCompra();
		return controller.juegosMasVendidos(idCreador);
	}

	@Override
	public Integer darCantVentasCreador(Integer idCreador) {
		ControllerCompra controller = Fabric.getControllerCompra();
		return controller.darCantVentasCreador(idCreador);
	}

	@Override
	public Integer darCantVentasJuego(Integer idJuego) {
		ControllerCompra controller = Fabric.getControllerCompra();
		return controller.darCantVentasJuego(idJuego);
	}
	
	@Override
	public void agregarCategoria(String nombre) {
		ControllerJuego controller = Fabric.getControllerJuego();
		controller.crearCategoria(nombre);
	}
	
	@Override
	public void crearOferta(String nombre, Date fechaInicio, Date fechaFin, float descuento ) {
		ControllerOferta controller = Fabric.getControllerOferta();
		controller.crearOferta(nombre, fechaInicio, fechaFin, descuento);
	}
	
	@Override
	public List<DataOferta> listarOfertasPendientes() {
		ControllerOferta controller = Fabric.getControllerOferta();
		return controller.darOfertasPendientes();
	}
	
	@Override
	public void agregarJuegoAOferta(Integer idOferta, List<Integer> idJuegos) {
		ControllerOferta controller = Fabric.getControllerOferta();
		controller.agregarJuegosOferta(idOferta, idJuegos);
	}
	
	@Override
	public void quitarJuegoAOferta(Integer idOferta, List<Integer> idJuegos) {
		ControllerOferta controller = Fabric.getControllerOferta();
		controller.removerJuegosOferta(idOferta, idJuegos);
	}
	
	@Override
	public void publicarPost(TipoPost tipo, String contenido, String texto, Integer idJugador) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		controller.publicarPost(tipo, contenido, texto, idJugador);
	}
	
	@Override
	public List<DataComentario> darComentariosReportados(){
		ControllerJuego controller = Fabric.getControllerJuego();
		return controller.darComentariosReportados();
	}
	
	@Override
	public List<DataJuego> buscarJuegos(String nombre) {
		ControllerJuego controller = Fabric.getControllerJuego();
		return controller.buscarJuegos(nombre);
	}

	@Override
	public List<DataOferta> listarOfertas() {
		ControllerOferta controller = Fabric.getControllerOferta();
		return controller.listarOfertas();
	}

	@Override
	public DataPagina listarPost(Integer idJugador, Integer pagina) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		return controller.listarPost(idJugador, pagina);
	}
	
	@Override
	public void bloquearComentario(Integer idComentario) {
		ControllerJuego controller = Fabric.getControllerJuego();
		controller.bloquearComentario(idComentario);
	}
	
	@Override
	public void bloquearJuego(Integer idJuego) {
		ControllerJuego controller = Fabric.getControllerJuego();
		controller.bloquearJuego(idJuego);
	}
	
	@Override
	public void desbloquearJuego(Integer idJuego) {
		ControllerJuego controller = Fabric.getControllerJuego();
		controller.desbloquearJuego(idJuego);
	}

	@Override
	public void solicitarDesbloquearJuego(Integer idJuego) {
		ControllerJuego controller = Fabric.getControllerJuego();
		controller.solicitarDesbloqueoJuego(idJuego);
	}
	
	@Override
	public List<DataJuego> darJuegosReportados() {
		ControllerJuego controller = Fabric.getControllerJuego();
		return controller.darJuegosReportados();
	}
	
	@Override
	public List<DataJuego> darJuegosBloqueados(Integer idCreador) {
		ControllerJuego controller = Fabric.getControllerJuego();
		return controller.darJuegosBloqueados(idCreador);
	}
	
	@Override
	public List<DataJuego> darJuegosSolicitados() {
		ControllerJuego controller = Fabric.getControllerJuego();
		return controller.darJuegosSolicitados();
	}
	
	@Override
	public void reportarJuego(Integer idJuego) {
		ControllerJuego controller = Fabric.getControllerJuego();
		controller.reportarJuego(idJuego);
	}

	@Override
	public List<DataJugador> listarJugadores() {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		return controller.listarJugadores();
	}

	@Override
	public List<DataJuego> darJuegosEnOferaCreador(Integer idOferta, Integer idCreador) {
		ControllerOferta controller = Fabric.getControllerOferta();
		return controller.darJuegosEnOferaCreador(idOferta, idCreador);
	}

	@Override
	public List<DataJuego> darJuegosNoEnOferaCreador(Integer idOferta, Integer idCreador) {
		ControllerOferta controller = Fabric.getControllerOferta();
		return controller.darJuegosNoEnOferaCreador(idOferta, idCreador);
	}
	
	@Override
	public List<DataTag> listarTags() {
		ControllerJuego controller = Fabric.getControllerJuego();
		return controller.listarTags();
	}
}
