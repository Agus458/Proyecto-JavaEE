package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import data_types.DataCategoria;
import data_types.DataCreador;
import data_types.DataJuego;
import data_types.DataValoracion;
import model.Categoria;
import model.Creador;
import model.Juego;
import model.Jugador;
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
						if(juego.getCategorias() != null && !juego.getCategorias().isEmpty()) {
							for(DataCategoria aux : juego.getCategorias()) {
								Categoria categoria = categoriaPersistence.buscarCategoriaNombre(aux.getNombre());
								if(categoria != null) {
									categorias.add(categoria);
								} else {
									categorias.add(categoriaPersistence.insertarCategoria(aux));
								}
							}
						}
						
						Juego entity = juegoPersistence.insertarJuego(juego, categorias);
						
						
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
		DataJuego juego = new DataJuego(null, "", "", null, null, null, null, null);

		Juego aux = juegoPersistence.buscarJuegoId(id);

		if (aux != null) {
			juego = aux.darDatos();
		}

		return juego;
	}

	@Override
	public DataJuego buscarJuegoNombre(String nombre) {
		DataJuego juego = new DataJuego(null, "", "", null, null, null, null, null);

		Juego aux = juegoPersistence.buscarJuegoNombre(nombre);

		if (aux != null) {
			juego = aux.darDatos();
		}

		return juego;
	}

	@Override
	public Juego darJuego(Integer idJuego) {
		Juego juego = null;
		if(idJuego != null) {
			juego = this.juegoPersistence.buscarJuegoId(idJuego);
		}
		return juego;
	}

	@Override
	public List<DataCategoria> listarCategorias() {
		List<DataCategoria> categorias = new ArrayList<DataCategoria>();
		
		List<Categoria> cats = categoriaPersistence.listarCategorias();
		for(Categoria aux : cats) {
			categorias.add(aux.darDatos());
		}
		
		return categorias;
	}

	@Override
	public DataCreador darDatosCreadorJuego(Integer idJuego) {
		DataCreador creador = new DataCreador(null, "", "", "", "", "", null);
		
		Juego juego = this.darJuego(idJuego);
		if(juego != null) {
			creador = juego.darCreador();
		}
		
		return creador;
	}

	@Override
	public void valorarJuego(Integer valoracion, Integer idJuego, Integer idJugador) {
		if(valoracion != null && valoracion >= 1 && valoracion <= 5) {
			if(idJuego != null && idJugador != null) {
				
				Jugador jugador = this.persistenceUsuario.buscarJugadorId(idJugador);
				if(jugador != null) {
					
					Juego juego = this.darJuego(idJuego);
					if(juego != null) {
						
						if(jugador.estaEnBiblioteca(juego)) {
							
							ReseniaDAO reseniaPersistence = Fabric.getReseniaDAO();
							Valoracion val = jugador.darValoracionJuego(juego);
							
							if(val == null) {
								val = reseniaPersistence.insertarValoracion(valoracion, juego, jugador);
								jugador.agregarValoracion(val);
								juego.agregarValoracion(val);
							} else {
								reseniaPersistence.actualizarValoracion(val, valoracion);
							}
								
						}
						
					}
					
				}
				
			}
		}
	}

}
