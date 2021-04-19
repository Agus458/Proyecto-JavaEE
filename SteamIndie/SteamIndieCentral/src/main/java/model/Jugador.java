package model;

import java.io.Serializable;
import javax.persistence.*;

import data_types.DataJugador;

/**
 * Entity implementation class for Entity: Jugador
 *
 */
@Entity
@Table(name = "jugadores")
public class Jugador extends Usuario implements Serializable {

	// Attributes
	
	private static final long serialVersionUID = 1L;

	// Constructors
	
	/*
	 * Default constructor
	 */
	public Jugador() {
		super();
	}

	/**
	 * Constructor for the entity class Jugador
	 * @param nombre
	 * @param apellido
	 * @param email
	 * @param password
	 * @param nickname
	 */
	public Jugador(String nombre, String apellido, String email, String password, String nickname) {
		super(nombre, apellido, email, password, nickname);
	}
   
	// Methods
	
	public DataJugador darDatos() {
		return new DataJugador(this.getNombre(), this.getApellido(), this.getEmail(), this.getPassword(), this.getNickname());
	}
}
