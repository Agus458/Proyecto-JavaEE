package model;

import java.io.Serializable;
import javax.persistence.*;

import model.DataTypes.DataJugador;

/**
 * Entity implementation class for Entity: Jugador
 *
 */
@Entity
@Table(name = "jugador")
@PrimaryKeyJoinColumn(name = "usuario_nick")
public class Jugador extends Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	// Constructors
	
	public Jugador() {
		super();
	}

	/**
	 * Constructor para la clase Jugador con parametros:
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param edad
	 * @param email
	 * @param password
	 */
	public Jugador(String nick, String nombre, String apellido, Integer edad, String email, String password) {
		super(nick, nombre, apellido, edad, email, password);
		// TODO Auto-generated constructor stub
	}
	
	public DataJugador darDatos() {
		return new DataJugador(this.getNick(), this.getNombre(), this.getApellido(), this.getEdad(), this.getEmail(), this.getPassword());
	}

}
