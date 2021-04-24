package persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import data_types.DataCategoria;
import model.Categoria;

/**
 * Session Bean implementation class CategoriaDAOImp
 */
@Stateless
public class CategoriaDAOImp implements CategoriaDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SteamIndieUnit");
	
    // Constructor
    
	/**
     * Default constructor. 
     */
    public CategoriaDAOImp() {
        
    }

    // Methods
    
	@Override
	public Categoria insertarCategoria(DataCategoria categoria) {
		Categoria entity = null;
		
		if(categoria != null) {
			
			EntityManager em = emf.createEntityManager();
			
			try {
				
				em.getTransaction().begin();
				
				entity = new Categoria(categoria.getNombre());
				
				em.persist(entity);
				
				em.getTransaction().commit();

			} catch (Exception e) {
				em.getTransaction().rollback();
			}
			
			em.close();
			
		}
		
		return entity;
	}

	@Override
	public List<Categoria> listarCategorias() {
		EntityManager em = emf.createEntityManager();
		List<Categoria> categorias = null;
		
		try {
			
			Query query = em.createQuery("SELECT c FROM Categoria c");
			@SuppressWarnings("unchecked")
			List<Categoria> cats = query.getResultList();
			
			categorias = cats;
			
		} catch (Exception e) {
			
		}
		
		em.close();
		return categorias;
	}

	@Override
	public Categoria buscarCategoriaId(Integer id) {
		Categoria categoria = null;
		
		if(id != null) {
			EntityManager em = emf.createEntityManager();
			
			try {
				
				categoria = em.find(Categoria.class, id);
				
			} catch (Exception e) {
				
			}
			
			em.close();
		}
		
		return categoria;
	}

	@Override
	public Categoria buscarCategoriaNombre(String nombre) {
		Categoria categoria = null;
		
		if(nombre != null) {
			EntityManager em = emf.createEntityManager();
			
			try {
				
				Query query = em.createQuery("SELECT c FROM Categoria c WHERE c.nombre = :nombre_categoria");
				query.setParameter("nombre_categoria", nombre);
				
				categoria = (Categoria) query.getSingleResult();
				
			} catch (Exception e) {
				
			}
			
			em.close();
		}
		
		return categoria;
	}

    
    
}
