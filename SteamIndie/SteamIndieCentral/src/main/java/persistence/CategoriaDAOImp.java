package persistence;

import java.util.ArrayList;
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
	public void insertarCategoria(DataCategoria categoria) {
		if(categoria != null) {
			
			EntityManager em = emf.createEntityManager();
			
			try {
				
				Categoria entity = new Categoria(categoria.getNombre());
				
				em.persist(entity);
				
			} catch (Exception e) {
				
			}
			
			em.close();
			
		}
	}

	@Override
	public List<DataCategoria> listarCategorias() {
		EntityManager em = emf.createEntityManager();
		List<DataCategoria> categorias = new ArrayList<DataCategoria>();
		
		try {
			
			Query query = em.createQuery("SELECT c FROM Categoria c");
			@SuppressWarnings("unchecked")
			List<Categoria> cats = query.getResultList();
			
			for(Categoria aux : cats) {
				categorias.add(aux.darDatos());
			}
			
		} catch (Exception e) {
			
		}
		
		em.close();
		return categorias;
	}

	@Override
	public DataCategoria buscarCategoriaId(Integer id) {
		DataCategoria categoria = new DataCategoria(null, "");
		
		if(id != null) {
			EntityManager em = emf.createEntityManager();
			
			try {
				
				Categoria aux = em.find(Categoria.class, id);
				if(aux != null) {
					categoria = aux.darDatos();
				}
				
			} catch (Exception e) {
				
			}
			
			em.close();
		}
		
		return categoria;
	}

	@Override
	public DataCategoria buscarCategoriaNombre(String nombre) {
		DataCategoria categoria = new DataCategoria(null, "");
		
		if(nombre != null) {
			EntityManager em = emf.createEntityManager();
			
			try {
				
				Query query = em.createQuery("SELECT c FROM Categoria c WHERE c.nombre = :nombre_categoria");
				query.setParameter("nombre_categoria", nombre);
				
				Categoria aux = (Categoria) query.getSingleResult();
				
				if(aux != null) {
					categoria = aux.darDatos();
				}
				
				
			} catch (Exception e) {
				
			}
			
			em.close();
		}
		
		return categoria;
	}

    
    
}
