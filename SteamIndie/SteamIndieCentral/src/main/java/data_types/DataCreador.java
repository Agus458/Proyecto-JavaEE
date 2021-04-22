/**
 * 
 */
package data_types;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @author Agustín
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataCreador extends DataUsuario{

	// Attributes
	
	private List<DataPublicacion> publicaciones;
	
	/**
	 * Default constructor
	 */
	public DataCreador() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param email
	 * @param password
	 * @param nickname
	 */
	public DataCreador(Integer id, String nombre, String apellido, String email, String password, String nickname, List<DataPublicacion> publicaciones) {
		super(id, nombre, apellido, email, password, nickname);
		this.publicaciones = publicaciones;
	}

	// Getters
	
	/**
	 * @return the publicaciones
	 */
	public List<DataPublicacion> getPublicaciones() {
		return publicaciones;
	}
	
}
