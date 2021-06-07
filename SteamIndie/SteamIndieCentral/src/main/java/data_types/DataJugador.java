/**
 * 
 */
package data_types;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * DataType implementation for entity class Jugador
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataJugador extends DataUsuario{

	private List<DataPost> posts;
	
	/**
	 * Default constructor
	 */
	public DataJugador() {
		super();
	}

	/**
	 * Constructor for DataType Jugador with params:
	 * @param nombre
	 * @param apellido
	 * @param email
	 * @param password
	 * @param nickname
	 */
	public DataJugador(Integer id, String nombre, String apellido, String email, String password, String nickname, List<DataPost> posts) {
		super(id, nombre, apellido, email, password, nickname);
		this.posts = posts;
	}

	/**
	 * @return the posts
	 */
	public List<DataPost> getPosts() {
		return posts;
	}

	/**
	 * @param posts the posts to set
	 */
	public void setPosts(List<DataPost> posts) {
		this.posts = posts;
	}
	
}
