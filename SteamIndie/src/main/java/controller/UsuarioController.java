package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;
import model.DataTypes.DataUsuario;

/**
 * Session Bean implementation class UsuarioController
 */
@Stateless
public class UsuarioController implements UsuarioControllerLocal {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SteamIndieUnit");
	private EntityManager em = emf.createEntityManager();
	
    /**
     * Default constructor. 
     */
    public UsuarioController() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retorna true si el usuario se encuentra registrado 
     */
    public Boolean existeUsuario(String email) {
    	
    }
    
    public void registrarUsuario(DataUsuario du) {
    	Usuario usu = new Usuario(du.getNombre(),du.getApellido(),du.getEdad(),du.getEmail(),du.getPassword());
    	try {
			em.getTransaction().begin();
			em.persist(usu);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
    }
    
}
