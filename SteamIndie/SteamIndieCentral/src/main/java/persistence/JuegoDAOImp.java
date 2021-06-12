package persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import data_types.DataJuego;
import model.Categoria;
import model.Creador;
import model.Juego;
import model.Media;
import model.Publicacion;
import model.Tag;

/**
 * Session Bean implementation class JuegoDAOImp
 */
@Stateless
public class JuegoDAOImp implements JuegoDAO {

	private EntityManager em = Persistence.createEntityManagerFactory("SteamIndieUnit").createEntityManager();

	/**
	 * Default constructor.
	 */
	public JuegoDAOImp() {

	}

	@Override
	public Juego insertarJuego(DataJuego juego, List<Categoria> categorias, List<Tag> tags) {
		Juego entity = null;
		if (juego != null) {

			try {
				em.getTransaction().begin();
				
				Media media = null;
				if(juego.getMedia() != null) {
					media = new Media(juego.getMedia().getLogo(), juego.getMedia().getVideos(), juego.getMedia().getImagenes());
				}
				
				entity = new Juego(juego.getNombre(), juego.getDescripcion(), juego.getPrecio(), media, categorias, tags);

				em.persist(entity);
				em.getTransaction().commit();
			} catch (Exception e) {
				em.getTransaction().rollback();
			}

		}
		return entity;
	}

	@Override
	public List<Juego> listarJuegos() {
		List<Juego> juegos = new ArrayList<Juego>();

		try {

			Query query = em.createQuery("SELECT j FROM Juego j");
			@SuppressWarnings("unchecked")
			List<Juego> jue = query.getResultList();

			juegos = jue;

		} catch (Exception e) {

		}

		return juegos;
	}

	@Override
	public Juego buscarJuegoId(Integer id) {
		Juego juego = null;

		if (id != null) {

			try {

				juego = em.find(Juego.class, id);

			} catch (Exception e) {

			}

		}

		return juego;
	}

	@Override
	public Juego buscarJuegoNombre(String nombre) {
		Juego juego = null;

		if (nombre != null) {

			try {

				Query query = em.createQuery("SELECT j FROM Juego j WHERE j.nombre = :nombre");
				query.setParameter("nombre", nombre);

				juego = (Juego) query.getSingleResult();

			} catch (Exception e) {
				
			}

		}

		return juego;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Juego> buscarJuegos(String nombre) {
		List<Juego> juegos = new ArrayList<Juego>();

		if (nombre != null) {

			try {

				Query query = em.createQuery("SELECT j FROM Juego j WHERE j.nombre like CONCAT('%',:nombre,'%')");
				query.setParameter("nombre", nombre);

				juegos = query.getResultList();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return juegos;
	}
	
	@Override
	public Publicacion crearPublicacion(Creador creador, Juego juego, Date fechaPublicacion) {
		Publicacion entity = null;

		if (creador != null && juego != null && fechaPublicacion != null) {

			try {
				em.getTransaction().begin();

				entity = new Publicacion(creador, juego, fechaPublicacion);

				em.persist(entity);

				// Traer al contexto de persistencia
				creador = em.merge(creador);
				juego = em.merge(juego);

				creador.agregarPublicacion(entity);
				juego.setPublicacion(entity);

				em.getTransaction().commit();
			} catch (Exception e) {
				em.getTransaction().rollback();
				e.printStackTrace();
			}

		}

		return entity;
	}

	@Override
	public void update(Juego juego) {
		
		try {
			em.getTransaction().begin();
			
			em.merge(juego);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
	}

}
