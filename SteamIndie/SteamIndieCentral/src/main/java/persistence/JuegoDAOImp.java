package persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import data_types.DataJuego;
import model.Categoria;
import model.Creador;
import model.Juego;
import model.Media;
import model.Publicacion;

/**
 * Session Bean implementation class JuegoDAOImp
 */
@Stateless
public class JuegoDAOImp implements JuegoDAO {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SteamIndieUnit");

	/**
	 * Default constructor.
	 */
	public JuegoDAOImp() {

	}

	@Override
	public Juego insertarJuego(DataJuego juego, List<Categoria> categorias) {
		Juego entity = null;
		if (juego != null) {

			EntityManager em = emf.createEntityManager();

			try {
				em.getTransaction().begin();
				
				Media media = null;
				if(juego.getMedia() != null) {
					media = new Media(juego.getMedia().getLogo(), juego.getMedia().getVideos(), juego.getMedia().getImagenes());
				}
				
				entity = new Juego(juego.getNombre(), juego.getDescripcion(), juego.getPrecio(), media, categorias);

				em.persist(entity);
				em.getTransaction().commit();
			} catch (Exception e) {
				em.getTransaction().rollback();
			}

			em.close();

		}
		return entity;
	}

	@Override
	public List<Juego> listarJuegos() {
		EntityManager em = emf.createEntityManager();
		List<Juego> juegos = new ArrayList<Juego>();

		try {

			Query query = em.createQuery("SELECT j FROM Juego j");
			@SuppressWarnings("unchecked")
			List<Juego> jue = query.getResultList();

			juegos = jue;

		} catch (Exception e) {

		}

		em.close();
		return juegos;
	}

	@Override
	public Juego buscarJuegoId(Integer id) {
		Juego juego = null;

		if (id != null) {

			EntityManager em = emf.createEntityManager();

			try {

				juego = em.find(Juego.class, id);

			} catch (Exception e) {

			}

			em.close();

		}

		return juego;
	}

	@Override
	public Juego buscarJuegoNombre(String nombre) {
		Juego juego = null;

		if (nombre != null) {

			EntityManager em = emf.createEntityManager();

			try {

				Query query = em.createQuery("SELECT j FROM Juego j WHERE j.nombre = :nombre");
				query.setParameter("nombre", nombre);

				juego = (Juego) query.getSingleResult();

			} catch (Exception e) {
				
			}

			em.close();

		}

		return juego;
	}

	@Override
	public Publicacion crearPublicacion(Creador creador, Juego juego, Date fechaPublicacion) {
		Publicacion entity = null;

		if (creador != null && juego != null && fechaPublicacion != null) {
			EntityManager em = emf.createEntityManager();

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

			em.close();
		}

		return entity;
	}

}
