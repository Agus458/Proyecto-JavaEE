package persistence;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Oferta;

/**
 * Session Bean implementation class OfertaDAOImp
 */
@Stateless
public class OfertaDAOImp implements OfertaDAO {

	private EntityManager em = Persistence.createEntityManagerFactory("SteamIndieUnit").createEntityManager();

	/**
	 * Default constructor.
	 */
	public OfertaDAOImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardar(Oferta oferta) {

		try {
			em.getTransaction().begin();

			em.persist(oferta);

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void actualizar(Oferta oferta) {

		try {
			em.getTransaction().begin();

			em.merge(oferta);

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	@Override
	public Oferta buscarId(Integer idOferta) {

		try {

			Oferta aux = em.find(Oferta.class, idOferta);
			if (aux != null)
				return aux;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Oferta buscarNombre(String nombreOferta) {

		try {

			Query query = em.createQuery("SELECT o FROM Oferta o WHERE o.nombre = :nombre");
			query.setParameter("nombre", nombreOferta);

			Oferta aux = (Oferta) query.getSingleResult();
			if (aux != null)
				return aux;

		} catch (Exception e) {
		}

		return null;
	}

	@Override
	public List<Oferta> darOfertas() {

		try {

			Query query = em.createQuery("SELECT o FROM Oferta o");
			
			@SuppressWarnings("unchecked")
			List<Oferta> aux = query.getResultList();

			return aux;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList<Oferta>();
	}

}
