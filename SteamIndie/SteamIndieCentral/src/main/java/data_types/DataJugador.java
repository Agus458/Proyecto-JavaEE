/**
 * 
 */
package data_types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * DataType implementation for entity class Jugador
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataJugador extends DataUsuario{
	
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
	public DataJugador(Integer id, String nombre, String apellido, String email, String password, String nickname) {
		super(id, nombre, apellido, email, password, nickname);
	}

}
