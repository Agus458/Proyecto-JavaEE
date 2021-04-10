package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Jugador
 *
 */
@Entity
@Table(name = "jugador")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Jugador extends Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	// Constructors
	
	public Jugador() {
		super();
	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param edad
	 * @param email
	 * @param password
	 */
	public Jugador(String nombre, String apellido, Integer edad, String email, String password) {
		super(nombre, apellido, edad, email, password);
		// TODO Auto-generated constructor stub
	}

}
