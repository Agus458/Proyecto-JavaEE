package persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import data_types.*;
import model.Admin;
import model.Carrito;
import model.Creador;
import model.Jugador;

/**
 * Session Bean implementation class UsuarioDAOImp
 */
@Stateless
public class UsuarioDAOImp implements UsuarioDAO {

	private EntityManager em = Persistence.createEntityManagerFactory("SteamIndieUnit").createEntityManager();

	/**
	 * Default constructor.
	 */
	public UsuarioDAOImp() {
	}

	@Override
	public Jugador insertarJugador(DataJugador jugador) {
		Jugador entity = null;

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

		return entity;
	}

	@Override
	public Creador insertarCreador(DataCreador creador) {
		Creador entity = null;

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

		return entity;
	}

	@Override
	public List<Jugador> listarJugadores() {
		List<Jugador> jugadores = null;

		try {

			// Extrae todos los jugadores de la base de datos
			Query query = em.createQuery("SELECT j FROM Jugador j");
			@SuppressWarnings("unchecked")
			List<Jugador> aux = query.getResultList();

			jugadores = aux;

		} catch (Exception e) {

		}

		return jugadores;
	}

	@Override
	public List<Creador> listarCreadores() {
		List<Creador> creadores = null;

		try {

			// Extrae todos los creadores de la base de datos
			Query query = em.createQuery("SELECT c FROM Creador c");
			@SuppressWarnings("unchecked")
			List<Creador> aux = query.getResultList();

			creadores = aux;

		} catch (Exception e) {

		}
		return creadores;
	}

	@Override
	public Jugador buscarJugadorEmail(String email) {
		Jugador jugador = null;

		try {

			Query query = em.createQuery("SELECT j FROM Jugador j WHERE j.email = :email");
			query.setParameter("email", email);

			jugador = (Jugador) query.getSingleResult();

		} catch (Exception e) {

		}

		return jugador;
	}

	@Override
	public Jugador buscarJugadorNick(String nick) {
		Jugador jugador = null;

		try {

			Query query = em.createQuery("SELECT j FROM Jugador j WHERE j.nickname = :nick");
			query.setParameter("nick", nick);

			jugador = (Jugador) query.getSingleResult();

		} catch (Exception e) {

		}

		return jugador;
	}

	@Override
	public Jugador buscarJugadorId(Integer id) {
		Jugador jugador = null;

		try {

			jugador = em.find(Jugador.class, id);

		} catch (Exception e) {

		}

		return jugador;
	}

	@Override
	public Creador buscarCreadorEmail(String email) {
		Creador creador = null;

		try {

			Query query = em.createQuery("SELECT c FROM Creador c WHERE c.email = :email");
			query.setParameter("email", email);

			creador = (Creador) query.getSingleResult();

		} catch (Exception e) {

		}

		return creador;
	}

	@Override
	public Creador buscarCreadorNick(String nick) {
		Creador creador = null;

		try {

			Query query = em.createQuery("SELECT c FROM Creador c WHERE c.nickname = :nick");
			query.setParameter("nick", nick);

			creador = (Creador) query.getSingleResult();

		} catch (Exception e) {

		}

		return creador;
	}

	@Override
	public Creador buscarCreadorId(Integer id) {
		Creador creador = null;

		try {

			creador = em.find(Creador.class, id);

		} catch (Exception e) {

		}

		return creador;
	}

	@Override
	public void actualizarJugador(Jugador jugador) {
		if (jugador != null) {

			try {
				em.getTransaction().begin();

				em.persist(jugador);

				em.getTransaction().commit();
			} catch (Exception e) {
				em.getTransaction().rollback();
			}

		}
	}

	@Override
	public void removerCarrito(Carrito carrito) {
		if(carrito != null) {
			try {
				em.getTransaction().begin();
				
				em.remove(carrito);
				
				em.getTransaction().commit();
			}catch (Exception e) {
				em.getTransaction().rollback();
			}
		}
	}

	@Override
	public Admin buscarAdminEmail(String email) {
		Admin admin = null;

		try {

			Query query = em.createQuery("SELECT a FROM Admin a WHERE a.email = :email");
			query.setParameter("email", email);

			admin = (Admin) query.getSingleResult();

		} catch (Exception e) {

		}

		return admin;
	}

	@Override
	public Admin buscarAdminNick(String nick) {
		Admin admin = null;

		try {

			Query query = em.createQuery("SELECT a FROM Admin a WHERE a.nickname = :nick");
			query.setParameter("nick", nick);

			admin = (Admin) query.getSingleResult();

		} catch (Exception e) {

		}

		return admin;
	}

	@Override
	public Admin buscarAdminId(Integer id) {
		Admin admin = null;

		try {

			admin = em.find(Admin.class, id);

		} catch (Exception e) {

		}

		return admin;
	}

	@Override
	public Admin insertarAdmin(DataUsuario admin) {
		Admin entity = null;

		try {
			em.getTransaction().begin();

			entity = new Admin(admin.getNombre(), admin.getApellido(), admin.getEmail(), admin.getPassword(), admin.getNickname());
			em.persist(entity);

			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		return entity;
	}

}
