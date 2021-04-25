package model;

import java.io.Serializable;
import javax.persistence.*;

import data_types.DataCarrito;
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

	private Float saldo;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Carrito carrito;

	// Constructors

	/*
	 * Default constructor
	 */
	public Jugador() {
		super();
	}

	/**
	 * Constructor for the entity class Jugador
	 * 
	 * @param nombre
	 * @param apellido
	 * @param email
	 * @param password
	 * @param nickname
	 */
	public Jugador(String nombre, String apellido, String email, String password, String nickname) {
		super(nombre, apellido, email, password, nickname);
		this.saldo = new Float(0);
		this.carrito = null;
	}

	// Getters

	/**
	 * @return the saldo
	 */
	public Float getSaldo() {
		return saldo;
	}

	/**
	 * @return the carrito
	 */
	public Carrito getCarrito() {
		return carrito;
	}

	// Setters

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	/**
	 * @param carrito the carrito to set
	 */
	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	// Methods

	public DataJugador darDatos() {
		return new DataJugador(this.getId(), this.getNombre(), this.getApellido(), this.getEmail(), this.getPassword(),
				this.getNickname());
	}

	public DataCarrito darDatosCarrito() {
		if (this.carrito != null) {
			return this.carrito.darDatos();
		}
		return null;
	}

	public void agregarAlCarrito(Juego juego) {
		if (this.carrito != null) {
			if (!this.carrito.estaElJuego(juego)) {
				this.carrito.agregarJuego(juego);
			}
		} else {
			this.carrito = new Carrito(this);
			this.carrito.agregarJuego(juego);
		}
	}
	
	public void removerJuegoCarrito(Juego juego) {
		if(this.carrito != null) {
			if(this.carrito.estaElJuego(juego)) {
				this.carrito.removerJuego(juego);
			}
		}
	}
}
