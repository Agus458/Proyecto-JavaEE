package persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

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

	public Valoracion actualizarValoracion(Valoracion valoracion , Integer val) {
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
	
}
