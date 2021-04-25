package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import data_types.DataCategoria;
import data_types.DataJuego;
import model.Categoria;
import model.Creador;
import model.Juego;
import persistence.CategoriaDAO;
import persistence.JuegoDAO;
import persistence.JuegoDAOImp;
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

				if (!this.nombreEnUso(juego.getNombre())) {

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
	public Boolean nombreEnUso(String nombre) {
		Boolean enUso = false;

		if (nombre != null) {
			Juego aux = juegoPersistence.buscarJuegoNombre(nombre);
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
		DataJuego juego = new DataJuego(null, "", "", null, null, null, null);

		Juego aux = juegoPersistence.buscarJuegoId(id);

		if (aux != null) {
			juego = aux.darDatos();
		}

		return juego;
	}

	@Override
	public DataJuego buscarJuegoNombre(String nombre) {
		DataJuego juego = new DataJuego(null, "", "", null, null, null, null);

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

}
