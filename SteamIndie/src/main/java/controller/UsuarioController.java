package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Jugador;
import model.DataTypes.DataUsuario;

/**
 * Session Bean implementation class UsuarioController
 */
@Stateless
public class UsuarioController implements UsuarioControllerLocal {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SteamIndieUnit");

	/**
	 * Default constructor.
	 */
	public UsuarioController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Retorna true si hay un usuario con el email ingresado
	 */
	@Override
	public Boolean emailEnUso(String email) {
		Boolean enUso = false;
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();

			Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :usu_email");
			query.setParameter("usu_email", email);

			List<?> res = query.getResultList();
			enUso = !(res.isEmpty());

			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
		return enUso;
	}
	
	/**
	 * Retorna true si hay un usuario con el nick ingresado
	 */
	@Override
	public Boolean nickEnUso(String nick) {
		Boolean enUso = false;
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();

			Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.nick = :usu_nick");
			query.setParameter("usu_nick", nick);

			List<?> res = query.getResultList();
			enUso = !(res.isEmpty());

			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
		return enUso;
	}

	/**
	 * Permite registrar un usuario en el sistema
	 */
	@Override
	public void registrarJugador(DataUsuario du) {
		if (!nickEnUso(du.getNick()) && !emailEnUso(du.getEmail())) {
			Jugador usu = new Jugador(du.getNick(),du.getNombre(),du.getApellido(),du.getEdad(),du.getEmail(),du.getPassword());
			EntityManager em = emf.createEntityManager();
			try {
				em.getTransaction().begin();

				em.persist(usu);
				
				em.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				em.getTransaction().rollback();
			}
			em.close();
		}

	}
	
	/**
	 * Permite listar todos los usuarios del sistema
	 */
	@Override
	public List<DataUsuario> listarUsuarios() {
		List<DataUsuario> usuarios = new ArrayList<DataUsuario>();
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();

			Query query = em.createQuery("SELECT j FROM Jugador j");

			@SuppressWarnings("unchecked")
			List<Jugador> jugadores = query.getResultList();
			for(Jugador aux : jugadores) {
				usuarios.add(aux.darDatos());
			}
			
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
		return usuarios;
	}

}
