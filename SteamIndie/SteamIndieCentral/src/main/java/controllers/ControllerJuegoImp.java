package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import data_types.DataCategoria;
import data_types.DataComentario;
import data_types.DataCreador;
import data_types.DataJuego;
import data_types.DataTag;
import enums.EstadoBloqueo;
import model.Categoria;
import model.Comentario;
import model.Creador;
import model.Juego;
import model.Jugador;
import model.Respuesta;
import model.Tag;
import model.Valoracion;
import persistence.CategoriaDAO;
import persistence.JuegoDAO;
import persistence.JuegoDAOImp;
import persistence.ReseniaDAO;
import persistence.UsuarioDAO;

/**
 * Session Bean implementation class ControllerJuegoImp
 */
@Stateless
public class ControllerJuegoImp implements ControllerJuego {

	@EJB
	private JuegoDAO juegoPersistence = new JuegoDAOImp();

	@EJB
	private UsuarioDAO persistenceUsuario = Fabric.getUsuarioPersistence();

	@EJB
	private CategoriaDAO categoriaPersistence = Fabric.getCategoriaPersistence();

	@EJB
	private ReseniaDAO reseniaPersistence = Fabric.getReseniaDAO();

	/**
	 * Default constructor.
	 */
	public ControllerJuegoImp() {

	}

	@Override
	public void publicarJuego(DataJuego juego, Integer id) {
		if (juego != null && id != null) {
			Creador creador = persistenceUsuario.buscarCreadorId(id);

			// Continua si el creador es valido;
			if (creador != null) {

				if (!this.nombreJuegoEnUso(juego.getNombre())) {

					try {
						List<Categoria> categorias = new ArrayList<Categoria>();
						if (juego.getCategorias() != null && !juego.getCategorias().isEmpty()) {
							for (DataCategoria aux : juego.getCategorias()) {
								Categoria categoria = categoriaPersistence.buscarCategoriaNombre(aux.getNombre());
								if (categoria != null) {
									categorias.add(categoria);
								}
							}
						}

						List<Tag> tags = new ArrayList<Tag>();
						if (juego.getTags() != null && !juego.getTags().isEmpty()) {
							for (DataTag aux : juego.getTags()) {
								Tag tag = categoriaPersistence.buscarTagNombre(aux.getNombre());
								if (tag != null) {
									tags.add(tag);
								} else {
									tags.add(categoriaPersistence.insertarTag(aux));
								}
							}
						}

						Juego entity = juegoPersistence.insertarJuego(juego, categorias, tags);

						juegoPersistence.crearPublicacion(creador, entity, new Date());

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	public Boolean nombreJuegoEnUso(String nombreJuego) {
		Boolean enUso = false;

		if (nombreJuego != null) {
			Juego aux = juegoPersistence.buscarJuegoNombre(nombreJuego);
			if (aux != null) {
				enUso = true;
			}
		}

		return enUso;
	}

	@Override
	public List<DataJuego> listarJuegos() {
		List<DataJuego> juegos = new ArrayList<DataJuego>();

		List<Juego> games = juegoPersistence.listarJuegos();

		for (Juego aux : games) {
			juegos.add(aux.darDatos());
		}

		return juegos;
	}

	@Override
	public DataJuego buscarJuegoId(Integer id) {
		DataJuego juego = new DataJuego(null, "", "", null, null, null, null, null, null, null, null);

		Juego aux = juegoPersistence.buscarJuegoId(id);

		if (aux != null) {
			juego = aux.darDatos();
		}

		return juego;
	}

	@Override
	public DataJuego buscarJuegoNombre(String nombre) {
		DataJuego juego = new DataJuego(null, "", "", null, null, null, null, null, null, null, null);

		Juego aux = juegoPersistence.buscarJuegoNombre(nombre);

		if (aux != null) {
			juego = aux.darDatos();
		}

		return juego;
	}

	@Override
	public Juego darJuego(Integer idJuego) {
		Juego juego = null;
		if (idJuego != null) {
			juego = this.juegoPersistence.buscarJuegoId(idJuego);
		}
		return juego;
	}

	@Override
	public List<DataCategoria> listarCategorias() {
		List<DataCategoria> categorias = new ArrayList<DataCategoria>();

		List<Categoria> cats = categoriaPersistence.listarCategorias();
		for (Categoria aux : cats) {
			categorias.add(aux.darDatos());
		}

		return categorias;
	}

	@Override
	public DataCreador darDatosCreadorJuego(Integer idJuego) {
		DataCreador creador = new DataCreador(null, "", "", "", "", "", null);

		Juego juego = this.darJuego(idJuego);
		if (juego != null) {
			creador = juego.darCreador();
		}

		return creador;
	}

	@Override
	public void valorarJuego(Integer valoracion, Integer idJuego, Integer idJugador) {
		if (valoracion != null && valoracion >= 1 && valoracion <= 5) {
			if (idJuego != null && idJugador != null) {

				Jugador jugador = this.persistenceUsuario.buscarJugadorId(idJugador);
				if (jugador != null) {

					Juego juego = this.darJuego(idJuego);
					if (juego != null) {

						if (jugador.estaEnBiblioteca(juego)) {

							Valoracion val = juego.darValoracionJugador(jugador);

							if (val == null) {
								val = reseniaPersistence.insertarValoracion(valoracion, juego, jugador);
								juego.agregarValoracion(val);

								this.juegoPersistence.update(juego);
							} else {
								reseniaPersistence.actualizarValoracion(val, valoracion);
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void comentarJuego(String contenido, Integer idJuego, Integer idJugador) {
		if (contenido != null && idJuego != null && idJugador != null) {

			Jugador jugador = this.persistenceUsuario.buscarJugadorId(idJugador);
			if (jugador != null) {

				Juego juego = this.darJuego(idJuego);
				if (juego != null) {

					if (jugador.estaEnBiblioteca(juego)) {

						Comentario comentario = reseniaPersistence.insertarComentario(contenido, juego, jugador);
						juego.agregarComentario(comentario);

						this.juegoPersistence.update(juego);

					}

				}

			}

		}
	}

	@Override
	public void responderComentario(Integer idComentario, String contenido, Integer idJugador) {
		if (idComentario != null && contenido != null && idJugador != null) {

			Jugador jugador = this.persistenceUsuario.buscarJugadorId(idJugador);
			if (jugador != null) {

				Comentario comentario = reseniaPersistence.buscarComentarioId(idComentario);
				if (comentario != null) {
					comentario.agregarRespuesta(new Respuesta(jugador, contenido, comentario));
					reseniaPersistence.actualizarComentario(comentario);
				}
			}
		}
	}

	@Override
	public void reportarComentario(Integer idComentario) {
		if (idComentario != null) {

			Comentario comentario = reseniaPersistence.buscarComentarioId(idComentario);
			if (comentario != null) {

				comentario.setReportes(comentario.getReportes() + 1);
				reseniaPersistence.actualizarComentario(comentario);

			}

		}
	}

	@Override
	public List<DataComentario> darUltimosComentariosJuego(Integer idJuego) {
		List<DataComentario> comentarios = new ArrayList<DataComentario>();

		Juego juego = juegoPersistence.buscarJuegoId(idJuego);
		if (juego != null) {
			List<Comentario> coments = reseniaPersistence.darUltimosComentariosJuego(juego);

			for (Comentario aux : coments) {
				comentarios.add(aux.darDatos());
			}
		}
		return comentarios;
	}

	@Override
	public void crearCategoria(String nombre) {
		if (nombre != null) {
			Categoria cat = this.categoriaPersistence.buscarCategoriaNombre(nombre);
			if (cat == null) {
				this.categoriaPersistence.insertarCategoria(new DataCategoria(null, nombre));
			}
		}
	}

	@Override
	public List<DataJuego> buscarJuegos(String nombre) {
		List<DataJuego> juegos = new ArrayList<DataJuego>();

		for (Juego j : juegoPersistence.buscarJuegos(nombre)) {
			juegos.add(j.darDatos());
		}

		return juegos;
	}

	@Override
	public List<DataComentario> darComentariosReportados() {
		List<DataComentario> comentarios = new ArrayList<DataComentario>();

		List<Comentario> coments = reseniaPersistence.darComentariosReportados();

		for (Comentario aux : coments) {
			comentarios.add(aux.darDatos());
		}

		return comentarios;
	}

	@Override
	public void bloquearComentario(Integer idComentario) {
		// TODO Auto-generated method stub
		if (idComentario != null) {
			Comentario comentario = this.reseniaPersistence.buscarComentarioId(idComentario);
			if (comentario != null) {
				comentario.setEstadoBloqueo(EstadoBloqueo.ACTIVO);
				this.reseniaPersistence.actualizarComentario(comentario);
			}
		}
	}

	@Override
	public void reportarJuego(Integer idJuego) {
		if (idJuego != null) {
			Juego juego = this.juegoPersistence.buscarJuegoId(idJuego);
			if (juego != null) {
				juego.setReportes(juego.getReportes() + 1);
				this.juegoPersistence.update(juego);
			}
		}
	}

	@Override
	public void bloquearJuego(Integer idJuego) {
		if (idJuego != null) {
			Juego juego = this.juegoPersistence.buscarJuegoId(idJuego);
			if (juego != null) {
				juego.setEstadoBloqueo(EstadoBloqueo.ACTIVO);
				this.juegoPersistence.update(juego);
			}
		}
	}

	@Override
	public List<DataJuego> darJuegosReportados() {
		List<DataJuego> juegos = new ArrayList<DataJuego>();

		List<Juego> games = reseniaPersistence.darJuegosReportados();

		for (Juego aux : games) {
			juegos.add(aux.darDatos());
		}

		return juegos;
	}

}
