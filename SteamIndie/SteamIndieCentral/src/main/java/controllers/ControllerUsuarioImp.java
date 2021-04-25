package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import data_types.DataCarrito;
import data_types.DataCreador;
import data_types.DataJugador;
import data_types.DataUsuario;
import model.Creador;
import model.Juego;
import model.Jugador;
import persistence.UsuarioDAO;
import persistence.UsuarioDAOImp;

/**
 * Session Bean implementation class ControllerUsuarioImp
 */
@Stateless
public class ControllerUsuarioImp implements ControllerUsuario {

	@EJB
	private UsuarioDAO usuarioPersistence = new UsuarioDAOImp();

	private ControllerJuego juegoController = Fabric.getControllerJuego();

	/**
	 * Default constructor.
	 */
	public ControllerUsuarioImp() {

	}

	@Override
	public void registrarJugador(DataJugador jugador) {
		if (!emailEnUso(jugador.getEmail()) && !nickEnUso(jugador.getNickname())) {
			usuarioPersistence.insertarJugador(jugador);
		}
	}

	@Override
	public void registrarCreador(DataCreador creador) {
		if (!emailEnUso(creador.getEmail()) && !nickEnUso(creador.getNickname())) {
			usuarioPersistence.insertarCreador(creador);
		}
	}

	@Override
	public Boolean emailEnUso(String email) {
		Boolean enUso = false;

		Jugador aux = usuarioPersistence.buscarJugadorEmail(email);
		if (aux != null) {
			enUso = true;
		} else {
			Creador aux2 = usuarioPersistence.buscarCreadorEmail(email);
			if (aux2 != null) {
				enUso = true;
			}
		}

		return enUso;
	}

	@Override
	public Boolean nickEnUso(String nick) {
		Boolean enUso = false;

		Jugador aux = usuarioPersistence.buscarJugadorNick(nick);
		if (aux != null) {
			enUso = true;
		} else {
			Creador aux2 = usuarioPersistence.buscarCreadorNick(nick);
			if (aux2 != null) {
				enUso = true;
			}
		}

		return enUso;
	}

	@Override
	public List<DataUsuario> listarUsuarios() {
		List<DataUsuario> usuarios = new ArrayList<DataUsuario>();

		List<Jugador> jugadores = usuarioPersistence.listarJugadores();
		for (Jugador aux : jugadores) {
			usuarios.add(aux.darDatos());
		}

		List<Creador> creadores = usuarioPersistence.listarCreadores();
		for (Creador aux : creadores) {
			usuarios.add(aux.darDatos());
		}

		return usuarios;
	}

	@Override
	public DataUsuario buscarUsuarioEmail(String email) {
		DataUsuario usuario = null;

		Jugador aux = usuarioPersistence.buscarJugadorEmail(email);
		if (aux != null) {
			usuario = aux.darDatos();
		} else {
			Creador aux2 = usuarioPersistence.buscarCreadorEmail(email);
			if (aux2 != null) {
				usuario = aux2.darDatos();
			}
		}

		return usuario;
	}

	@Override
	public DataUsuario buscarUsuarioNick(String nick) {
		DataUsuario usuario = null;

		Jugador aux = usuarioPersistence.buscarJugadorNick(nick);
		if (aux != null) {
			usuario = aux.darDatos();
		} else {
			Creador aux2 = usuarioPersistence.buscarCreadorNick(nick);
			if (aux2 != null) {
				usuario = aux2.darDatos();
			}
		}

		return usuario;
	}

	@Override
	public DataUsuario buscarUsuarioId(Integer id) {
		DataUsuario usuario = null;

		Jugador aux = usuarioPersistence.buscarJugadorId(id);
		if (aux != null) {
			usuario = aux.darDatos();
		} else {
			Creador aux2 = usuarioPersistence.buscarCreadorId(id);
			if (aux2 != null) {
				usuario = aux2.darDatos();
			}
		}

		return usuario;
	}

	@Override
	public DataCarrito darDatosCarritoJugador(Integer idJugador) {
		DataCarrito carrito = new DataCarrito(null, null, null);
		if (idJugador != null) {

			Jugador jugador = usuarioPersistence.buscarJugadorId(idJugador);
			if (jugador != null) {
				DataCarrito aux = jugador.darDatosCarrito();
				if (aux != null) {
					carrito = aux;
				}

			}

		}
		return carrito;
	}

	@Override
	public void agregarJuegoAlCarritoJugador(Integer idJugador, Integer idJuego) {
		if (idJugador != null && idJuego != null) {
			Jugador jugador = usuarioPersistence.buscarJugadorId(idJugador);
			if (jugador != null) {

				Juego juego = juegoController.darJuego(idJuego);

				if (juego != null) {
					jugador.agregarAlCarrito(juego);
					usuarioPersistence.actualizarJugador(jugador);
				}
			}
		}
	}

	@Override
	public void cargarBilleteraJugador(Integer idJugador, Float monto) {
		if (idJugador != null && monto != null) {

			Jugador jugador = usuarioPersistence.buscarJugadorId(idJugador);
			if (jugador != null) {
				Float saldo = jugador.getSaldo();
				jugador.setSaldo(saldo += monto);
				usuarioPersistence.actualizarJugador(jugador);
			}
		}
	}

	@Override
	public void eliminarJuegoDelCarritoJugador(Integer idJugador, Integer idJuego) {
		if (idJugador != null && idJuego != null) {
			Jugador jugador = usuarioPersistence.buscarJugadorId(idJugador);
			if (jugador != null) {

				Juego juego = juegoController.darJuego(idJuego);

				if (juego != null) {
					jugador.removerJuegoCarrito(juego);
					usuarioPersistence.actualizarJugador(jugador);
				}
			}
		}
	}

}
