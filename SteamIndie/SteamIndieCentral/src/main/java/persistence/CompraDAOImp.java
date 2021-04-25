package persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Compra;
import model.Juego;
import model.Jugador;

/**
 * Session Bean implementation class CompraDAOImp
 */
@Stateless
public class CompraDAOImp implements CompraDAO {

	private EntityManager em = Persistence.createEntityManagerFactory("SteamIndieUnit").createEntityManager();
	
    /**
     * Default constructor. 
     */
    public CompraDAOImp() {
        
    }

	@Override
	public void insertarComra(Jugador jugador, Juego juego) {
		if(jugador != null && juego != null) {
			
			try {
				em.getTransaction().begin();
				
				Compra entity = new Compra(jugador, juego);
				em.persist(entity);
				
				em.getTransaction().commit();
			}catch (Exception e) {
				em.getTransaction().rollback();
			}
			
		}
	}

	@Override
	public Compra darCompraJugador(Integer idJugador, Integer idJuego) {
		Compra compra = null;
		
		try {
			
			Query query = em.createQuery("SELECT c FROM Compra c");
			// TODO arreglar
		} catch (Exception e) {
			
		}
		
		return compra;
	}

}
