package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import data_types.DataAdmin;
import data_types.DataCarrito;
import data_types.DataCreador;
import data_types.DataJuego;
import data_types.DataJugador;
import data_types.DataUsuario;
import enums.TipoPost;
import model.Admin;
import model.Carrito;
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
	public void registrarAdmin(DataAdmin admin) {
		if (!emailEnUso(admin.getEmail()) && !nickEnUso(admin.getNickname())) {
			usuarioPersistence.insertarAdmin(admin);
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
			} else {
				Admin aux3 = usuarioPersistence.buscarAdminEmail(email);
				if(aux3 != null) {
					enUso = true;
				}
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
			} else {
				Admin aux3 = usuarioPersistence.buscarAdminNick(nick);
				if(aux3 != null) {
					enUso = true;
				}
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
		DataUsuario usuario = new DataUsuario(null, "", "", "", "", "");

		Jugador aux = usuarioPersistence.buscarJugadorEmail(email);
		if (aux != null) {
			usuario = aux.darDatos();
		} else {
			Creador aux2 = usuarioPersistence.buscarCreadorEmail(email);
			if (aux2 != null) {
				usuario = aux2.darDatos();
			} else {
				Admin aux3 = usuarioPersistence.buscarAdminEmail(email);
				if(aux3 != null) {
					usuario = aux3.darDatos();
				}
			}
		}

		return usuario;
	}

	@Override
	public DataUsuario buscarUsuarioNick(String nick) {
		DataUsuario usuario = new DataUsuario(null, "", "", "", "", "");

		Jugador aux = usuarioPersistence.buscarJugadorNick(nick);
		if (aux != null) {
			usuario = aux.darDatos();
		} else {
			Creador aux2 = usuarioPersistence.buscarCreadorNick(nick);
			if (aux2 != null) {
				usuario = aux2.darDatos();
			} else {
				Admin aux3 = usuarioPersistence.buscarAdminNick(nick);
				if(aux3 != null) {
					usuario = aux3.darDatos();
				}
			}
		}

		return usuario;
	}

	@Override
	public DataUsuario buscarUsuarioId(Integer id) {
		DataUsuario usuario = new DataUsuario(null, "", "", "", "", "");

		Jugador aux = usuarioPersistence.buscarJugadorId(id);
		if (aux != null) {
			usuario = aux.darDatos();
		} else {
			Creador aux2 = usuarioPersistence.buscarCreadorId(id);
			if (aux2 != null) {
				usuario = aux2.darDatos();
			} else {
				Admin aux3 = usuarioPersistence.buscarAdminId(id);
				if(aux3 != null) {
					usuario = aux3.darDatos();
				}
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
					if (!jugador.estaEnBiblioteca(juego)) {
						jugador.agregarAlCarrito(juego);
						usuarioPersistence.actualizarJugador(jugador);
					}
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
					Carrito carrito = jugador.removerJuegoCarrito(juego);
					if (carrito.estaVacio()) {
						jugador.setCarrito(null);
						carrito.setJugador(null);
						usuarioPersistence.removerCarrito(carrito);
					}
					usuarioPersistence.actualizarJugador(jugador);
				}
			}
		}
	}

	@Override
	public Float darSaldoJugador(Integer idJuagdor) {
		Float saldo = new Float(0);

		if (idJuagdor != null) {

			Jugador jugador = usuarioPersistence.buscarJugadorId(idJuagdor);
			if (jugador != null) {
				saldo = jugador.getSaldo();
			}

		}

		return saldo;
	}

	@Override
	public List<DataJuego> darBibliotecaJugador(Integer idJugador) {
		List<DataJuego> biblioteca = new ArrayList<DataJuego>();
		
		if(idJugador != null) {
			Jugador jugador = usuarioPersistence.buscarJugadorId(idJugador);
			if(jugador != null) {
				for(Juego aux : jugador.getJuegos()) {
					biblioteca.add(aux.darDatos());
				}
			}
		}
		
		return biblioteca;
	}

	@Override
	public void publicarPost(TipoPost tipo, String contenido, Integer idJuagdor) {
		if(tipo != null && contenido != null && idJuagdor != null) {
			Jugador jugador = this.usuarioPersistence.buscarJugadorId(idJuagdor);
			if(jugador != null) {
				jugador.agregarPost(tipo, contenido);
				this.usuarioPersistence.actualizarJugador(jugador);
			}
		}
	}

}
