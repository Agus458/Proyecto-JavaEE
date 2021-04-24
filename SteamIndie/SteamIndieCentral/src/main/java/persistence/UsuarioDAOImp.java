package persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import data_types.*;
import model.Creador;
import model.Jugador;

/**
 * Session Bean implementation class UsuarioDAOImp
 */
@Stateless
public class UsuarioDAOImp implements UsuarioDAO {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SteamIndieUnit");

	/**
	 * Default constructor.
	 */
	public UsuarioDAOImp() {
	}

	@Override
	public Jugador insertarJugador(DataJugador jugador) {
		Jugador entity = null;

		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();

			entity = new Jugador(jugador.getNombre(), jugador.getApellido(), jugador.getEmail(), jugador.getPassword(),
					jugador.getNickname());
			em.persist(entity);

			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();

		return entity;
	}

	@Override
	public Creador insertarCreador(DataCreador creador) {
		Creador entity = null;

		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();

			entity = new Creador(creador.getNombre(), creador.getApellido(), creador.getEmail(), creador.getPassword(),
					creador.getNickname());
			em.persist(entity);

			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();

		return entity;
	}

	@Override
	public List<Jugador> listarJugadores() {
		EntityManager em = emf.createEntityManager();
		List<Jugador> jugadores = null;

		try {

			// Extrae todos los jugadores de la base de datos
			Query query = em.createQuery("SELECT j FROM Jugador j");
			@SuppressWarnings("unchecked")
			List<Jugador> aux = query.getResultList();

			jugadores = aux;

		} catch (Exception e) {

		}

		em.close();
		return jugadores;
	}

	@Override
	public List<Creador> listarCreadores() {
		EntityManager em = emf.createEntityManager();
		List<Creador> creadores = null;

		try {

			// Extrae todos los creadores de la base de datos
			Query query = em.createQuery("SELECT c FROM Creador c");
			@SuppressWarnings("unchecked")
			List<Creador> aux = query.getResultList();

			creadores = aux;

		} catch (Exception e) {

		}

		em.close();

		return creadores;
	}

	@Override
	public Jugador buscarJugadorEmail(String email) {
		Jugador jugador = null;

		EntityManager em = emf.createEntityManager();

		try {

			Query query = em.createQuery("SELECT j FROM Jugador j WHERE j.email = :email");
			query.setParameter("email", email);

			jugador = (Jugador) query.getSingleResult();

		} catch (Exception e) {

		}

		em.close();

		return jugador;
	}

	@Override
	public Jugador buscarJugadorNick(String nick) {
		Jugador jugador = null;

		EntityManager em = emf.createEntityManager();

		try {

			Query query = em.createQuery("SELECT j FROM Jugador j WHERE j.nickname = :nick");
			query.setParameter("nick", nick);

			jugador = (Jugador) query.getSingleResult();

		} catch (Exception e) {

		}

		em.close();

		return jugador;
	}

	@Override
	public Jugador buscarJugadorId(Integer id) {
		Jugador jugador = null;

		EntityManager em = emf.createEntityManager();

		try {

			jugador = em.find(Jugador.class, id);

		} catch (Exception e) {

		}

		em.close();

		return jugador;
	}

	@Override
	public Creador buscarCreadorEmail(String email) {
		Creador creador = null;

		EntityManager em = emf.createEntityManager();

		try {

			Query query = em.createQuery("SELECT c FROM Creador c WHERE c.email = :email");
			query.setParameter("email", email);

			creador = (Creador) query.getSingleResult();

		} catch (Exception e) {

		}

		em.close();

		return creador;
	}

	@Override
	public Creador buscarCreadorNick(String nick) {
		Creador creador = null;

		EntityManager em = emf.createEntityManager();

		try {

			Query query = em.createQuery("SELECT c FROM Creador c WHERE c.nickname = :nick");
			query.setParameter("nick", nick);

			creador = (Creador) query.getSingleResult();

		} catch (Exception e) {

		}

		em.close();

		return creador;
	}

	@Override
	public Creador buscarCreadorId(Integer id) {
		Creador creador = null;

		EntityManager em = emf.createEntityManager();

		try {

			creador = em.find(Creador.class, id);

		} catch (Exception e) {

		}

		em.close();

		return creador;
	}

}
