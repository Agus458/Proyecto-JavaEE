package persistence;

import java.util.List;
import java.util.ArrayList;

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
	public void insertarJugador(DataJugador jugador) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();

			Jugador entity = new Jugador(jugador.getNombre(), jugador.getApellido(), jugador.getEmail(),
					jugador.getPassword(), jugador.getNickname());
			em.persist(entity);

			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
	}

	@Override
	public void insertarCreador(DataCreador creador) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();

			Creador entity = new Creador(creador.getNombre(), creador.getApellido(), creador.getEmail(),
					creador.getPassword(), creador.getNickname());
			em.persist(entity);

			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
	}

	@Override
	public List<DataUsuario> listarUsuarios() {
		EntityManager em = emf.createEntityManager();
		List<DataUsuario> usuarios = new ArrayList<DataUsuario>();

		try {

			// Extrae todos los jugadores de la base de datos
			Query query = em.createQuery("SELECT j FROM Jugador j");
			@SuppressWarnings("unchecked")
			List<Jugador> jugadores = query.getResultList();

			for (Jugador aux : jugadores) {
				usuarios.add(aux.darDatos());
			}

			// Extrae todos los creadores de la base de datos
			query = em.createQuery("SELECT c FROM Creador c");
			@SuppressWarnings("unchecked")
			List<Creador> creadores = query.getResultList();

			for (Creador aux : creadores) {
				usuarios.add(aux.darDatos());
			}

		} catch (Exception e) {

		}

		em.close();
		return usuarios;
	}

	@Override
	public DataUsuario buscarUsuarioEmail(String email) {
		EntityManager em = emf.createEntityManager();
		DataUsuario usuario = new DataUsuario(null, "", "", "", "", "");

		Jugador aux = null;
		Creador aux2 = null;

		try {

			Query query = em.createQuery("SELECT j FROM Jugador j WHERE j.email = :user_email")
					.setParameter("user_email", email);

			aux = (Jugador) query.getSingleResult();

		} catch (Exception e) {

		}

		if (aux != null) {
			usuario = aux.darDatos();
		} else {

			// En caso de ser Creador
			try {

				Query query = em.createQuery("SELECT c FROM Creador c WHERE c.email = :user_email")
						.setParameter("user_email", email);

				aux2 = (Creador) query.getSingleResult();

			} catch (Exception e) {

			}

			if (aux2 != null) {
				usuario = aux2.darDatos();
			}

		}

		return usuario;
	}

	@Override
	public DataUsuario buscarUsuarioNick(String nick) {
		EntityManager em = emf.createEntityManager();
		DataUsuario usuario = new DataUsuario(null, "", "", "", "", "");
		
		Jugador aux = null;
		Creador aux2 = null;

		try {

			Query query = em.createQuery("SELECT j FROM Jugador j WHERE j.nickname = :user_nick")
					.setParameter("user_nick", nick);

			aux = (Jugador) query.getSingleResult();

		} catch (Exception e) {

		}

		if (aux != null) {
			usuario = aux.darDatos();
		} else {

			// En caso de ser Creador
			try {

				Query query = em.createQuery("SELECT c FROM Creador c WHERE c.nickname = :user_nick")
						.setParameter("user_nick", nick);

				aux2 = (Creador) query.getSingleResult();

			} catch (Exception e) {

			}

			if (aux2 != null) {
				usuario = aux2.darDatos();
			}

		}

		return usuario;
	}

	@Override
	public DataUsuario buscarUsuarioId(Integer id) {
		DataUsuario usuario = new DataUsuario(null, "", "", "", "", "");

		if (id != null) {

			EntityManager em = emf.createEntityManager();

			try {

				Jugador aux = em.find(Jugador.class, id);

				if (aux != null) {

					usuario = aux.darDatos();

				} else {

					// En caso de ser Creador
					Creador aux2 = em.find(Creador.class, id);
					if (aux2 != null) {
						usuario = aux2.darDatos();
					}

				}

			} catch (Exception e) {

			}

			em.close();

		}

		return usuario;
	}

}
