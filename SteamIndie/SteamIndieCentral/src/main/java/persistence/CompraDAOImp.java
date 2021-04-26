package persistence;

import java.util.List;

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
	public Compra insertarCompra(Jugador jugador, List<Juego> juegos) {
		Compra entity = null;
		if(jugador != null && juegos != null) {
			try {
				em.getTransaction().begin();
				
				entity = new Compra(jugador, juegos);
				em.persist(entity);
				
				em.getTransaction().commit();
			}catch (Exception e) {
				em.getTransaction().rollback();
				e.printStackTrace();
			}
			
		}
		return entity;
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
