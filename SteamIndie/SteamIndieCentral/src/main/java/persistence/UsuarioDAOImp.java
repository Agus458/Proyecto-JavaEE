package persistence;

import java.util.List;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import data_types.*;
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
			
			Jugador entity = new Jugador(jugador.getNombre(), jugador.getApellido(), jugador.getEmail(), jugador.getPassword(), jugador.getNickname());
			em.persist(entity);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
    	em.close();
    }
    
    @Override
    public List<DataUsuario> listarUsuarios(){
    	EntityManager em = emf.createEntityManager();
    	List<DataUsuario> usuarios = new ArrayList<DataUsuario>();
    	
    	try {
		
    		// Extrae todos los jugadores de la base de datos
    		Query query = em.createQuery("SELECT j FROM Jugador j");
    		@SuppressWarnings("unchecked")
			List<Jugador> jugadores = query.getResultList();
    		
    		for(Jugador aux : jugadores) {
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
    	DataUsuario usuario = null;
    	
    	try {
			
    		Query query = em.createQuery("SELECT j FROM Jugador j WHERE j.email = :user_email").setParameter("user_email", email);
    		Jugador aux = (Jugador) query.getSingleResult();
    		
    		if(aux != null) {
    			usuario = aux.darDatos();
    		} else {
    			// Desarrollador
    		}
    		
		} catch (Exception e) {
			
		}
    	
    	return usuario;
    }

	@Override
	public DataUsuario buscarUsuarioNick(String nick) {
		EntityManager em = emf.createEntityManager();
    	DataUsuario usuario = null;
    	
    	try {
			
    		Query query = em.createQuery("SELECT j FROM Jugador j WHERE j.nickname = :user_nick").setParameter("user_nick", nick);
    		Jugador aux = (Jugador) query.getSingleResult();
    		
    		if(aux != null) {
    			usuario = aux.darDatos();
    		} else {
    			// Desarrollador
    		}
    		
		} catch (Exception e) {
			
		}
    	
    	return usuario;
	}
    
}
