package persistence;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Comentario;
import model.Juego;
import model.Jugador;
import model.Valoracion;

/**
 * Session Bean implementation class ReseniaDAOImp
 */
@Stateless
public class ReseniaDAOImp implements ReseniaDAO {

	private EntityManager em = Persistence.createEntityManagerFactory("SteamIndieUnit").createEntityManager();

	/**
	 * Default constructor.
	 */
	public ReseniaDAOImp() {

	}

	@Override
	public Valoracion insertarValoracion(Integer valoracion, Juego juego, Jugador jugador) {
		Valoracion entity = null;

		try {
			em.getTransaction().begin();

			entity = new Valoracion(jugador, valoracion, juego);
			em.persist(entity);

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}

		return entity;
	}

	public Valoracion actualizarValoracion(Valoracion valoracion, Integer val) {
		Valoracion entity = null;

		try {
			em.getTransaction().begin();

			entity = em.merge(valoracion);
			entity.setValoracion(val);

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}

		return entity;
	}

	@Override
	public Comentario insertarComentario(String contenido, Juego juego, Jugador jugador) {
		Comentario entity = null;

		try {
			em.getTransaction().begin();

			entity = new Comentario(jugador, juego, contenido);
			em.persist(entity);

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}

		return entity;
	}

	@Override
	public Comentario actualizarComentario(Comentario comentario) {
		try {
			em.getTransaction().begin();

			em.merge(comentario);

			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		return comentario;
	}

	@Override
	public Comentario buscarComentarioId(Integer idComentario) {
		Comentario comentario = null;

		try {

			comentario = em.find(Comentario.class, idComentario);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return comentario;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comentario> darUltimosComentariosJuego(Juego juego) {
		List<Comentario> comentarios = new ArrayList<Comentario>();

		try {
			Query query = em.createQuery(
					"SELECT c FROM Comentario c WHERE c.juego = :juego AND c.estadoBloqueo = enums.EstadoBloqueo.NOACTIVO ORDER BY c.fechaPublicacion DESC");
			query.setParameter("juego", juego);
			query.setMaxResults(10);

			comentarios = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return comentarios;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Comentario> darComentariosReportados() {
		List<Comentario> comentarios = new ArrayList<Comentario>();

		try {
			Query query = em.createQuery("SELECT c FROM Comentario c WHERE c.reportes > 0 ORDER BY c.reportes DESC");

			comentarios = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return comentarios;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Juego> darJuegosReportados() {
		List<Juego> juegos = new ArrayList<Juego>();

		try {
			Query query = em.createQuery("SELECT j FROM Juego j WHERE j.reportes > 0 ORDER BY j.reportes DESC");

			juegos = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return juegos;
	}
}
