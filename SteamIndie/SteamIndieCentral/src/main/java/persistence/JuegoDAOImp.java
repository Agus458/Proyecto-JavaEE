package persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import data_types.DataJuego;
import data_types.DataMedia;
import model.Categoria;
import model.Juego;
import model.Media;

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
	public void insertarJuego(DataJuego juego, List<Categoria> categorias) {
		if(juego != null) {
			
			EntityManager em = emf.createEntityManager();
			
			try {
				
				Media media = this.insertarMedia(juego.getMedia());
				
				Juego entity = new Juego(juego.getNombre(), juego.getDescripcion(), juego.getPrecio(), categorias, media);
				
				em.persist(entity);
				
			} catch (Exception e) {
				
			}
			
			em.close();
			
		}
	}

	@Override
	public List<DataJuego> listarJuegos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataJuego buscarJuegoId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataJuego buscarJuegosNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Media insertarMedia(DataMedia media) {
		Media entity = null;
		
		if(media != null) {
			
			EntityManager em = emf.createEntityManager();
			
			try {
				
				entity = new Media(media.getImagenes(), media.getVideos());
				
				em.persist(entity);
				
			} catch (Exception e) {
				
			}
			
			em.close();
			
		}
		return entity;
	}

}
