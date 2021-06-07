package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import data_types.DataMuro;
import data_types.DataPost;
import enums.TipoPost;

/**
 * Entity implementation class for Entity: Muro
 *
 */
@Entity
@Table(name = "muros")
public class Muro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Post> posts;

	public Muro() {
		super();
		this.posts = new ArrayList<Post>();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the posts
	 */
	public List<Post> getPosts() {
		return posts;
	}

	/**
	 * @param posts the posts to set
	 */
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	public DataMuro darDatos() {
		List<DataPost> p = new ArrayList<DataPost>();
		for (Post aux : this.posts) {
			p.add(aux.darDatos());
		}
		
		return new DataMuro(id, p);
	}
	
	public void agregarPost(TipoPost tipo, String contenido) {
		if (tipo != null && contenido != null) {
			this.posts.add(new Post(contenido, tipo));
		}
	}
}
