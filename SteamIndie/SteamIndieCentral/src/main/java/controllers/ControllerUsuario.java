package controllers;

import java.util.List;

import javax.ejb.Local;

import data_types.DataAdmin;
import data_types.DataCarrito;
import data_types.DataCreador;
import data_types.DataJuego;
import data_types.DataJugador;
import data_types.DataPagina;
import data_types.DataUsuario;
import enums.TipoPost;

@Local
public interface ControllerUsuario {

	public Boolean emailEnUso(String email);

	public Boolean nickEnUso(String nick);

	public void registrarJugador(DataJugador jugador);
	
	public void registrarCreador(DataCreador creador);
	
	public void registrarAdmin(DataAdmin admin);

	public List<DataUsuario> listarUsuarios();
	
	public List<DataJugador> listarJugadores();

	public DataUsuario buscarUsuarioEmail(String email);

	public DataUsuario buscarUsuarioNick(String nick);
	
	public DataUsuario buscarUsuarioId(Integer id);
	
	public DataCarrito darDatosCarritoJugador(Integer idJugador);
	
	public void agregarJuegoAlCarritoJugador(Integer idJugador, Integer idJuego);
	
	public void eliminarJuegoDelCarritoJugador(Integer idJugador, Integer idJuego);
	
	public void cargarBilleteraJugador(Integer idJugador, Float monto);
	
	public Float darSaldoJugador(Integer idJuagdor);

	public List<DataJuego> darBibliotecaJugador(Integer idJugador);
	
	public void publicarPost(TipoPost tipo, String contenido, String texto, Integer idJuagdor);
	
	public DataPagina listarPost(Integer idJugador, Integer pagina);
	
}
