package persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import data_types.DataCategoria;
import data_types.DataTag;
import model.Categoria;
import model.Tag;

/**
 * Session Bean implementation class CategoriaDAOImp
 */
@Stateless
public class CategoriaDAOImp implements CategoriaDAO {

	private EntityManager em = Persistence.createEntityManagerFactory("SteamIndieUnit").createEntityManager();

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

		if (categoria != null) {

			try {

				em.getTransaction().begin();

				entity = new Categoria(categoria.getNombre());

				em.persist(entity);

				em.getTransaction().commit();

			} catch (Exception e) {
				em.getTransaction().rollback();
			}

		}

		return entity;
	}

	@Override
	public List<Categoria> listarCategorias() {
		List<Categoria> categorias = null;

		try {

			Query query = em.createQuery("SELECT c FROM Categoria c");
			@SuppressWarnings("unchecked")
			List<Categoria> cats = query.getResultList();

			categorias = cats;

		} catch (Exception e) {

		}

		return categorias;
	}

	@Override
	public Categoria buscarCategoriaId(Integer id) {
		Categoria categoria = null;

		if (id != null) {

			try {

				categoria = em.find(Categoria.class, id);

			} catch (Exception e) {

			}

		}

		return categoria;
	}

	@Override
	public Categoria buscarCategoriaNombre(String nombre) {
		Categoria categoria = null;

		if (nombre != null) {

			try {

				Query query = em.createQuery("SELECT c FROM Categoria c WHERE c.nombre = :nombre_categoria");
				query.setParameter("nombre_categoria", nombre);

				categoria = (Categoria) query.getSingleResult();

			} catch (Exception e) {

			}

		}

		return categoria;
	}

	@Override
	public Tag insertarTag(DataTag tag) {
		Tag entity = null;

		if (tag != null) {

			try {

				em.getTransaction().begin();

				entity = new Tag(tag.getNombre());

				em.persist(entity);

				em.getTransaction().commit();

			} catch (Exception e) {
				em.getTransaction().rollback();
			}

		}

		return entity;
	}

	@Override
	public List<Tag> listarTags() {
		List<Tag> tags = null;

		try {

			Query query = em.createQuery("SELECT t FROM Tag t");
			@SuppressWarnings("unchecked")
			List<Tag> aux = query.getResultList();

			tags = aux;

		} catch (Exception e) {

		}

		return tags;
	}

	@Override
	public Tag buscarTagId(Integer id) {
		Tag tag = null;

		if (id != null) {

			try {

				tag = em.find(Tag.class, id);

			} catch (Exception e) {

			}

		}

		return tag;
	}

	@Override
	public Tag buscarTagNombre(String nombre) {
		Tag tag = null;

		if (nombre != null) {

			try {

				Query query = em.createQuery("SELECT t FROM Tag t WHERE t.nombre = :nombre_tag");
				query.setParameter("nombre_tag", nombre);

				tag = (Tag) query.getSingleResult();

			} catch (Exception e) {

			}

		}

		return tag;
	}

}
