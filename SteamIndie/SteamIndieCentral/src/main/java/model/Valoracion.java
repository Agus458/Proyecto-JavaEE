package model;

import java.io.Serializable;
import javax.persistence.*;

import data_types.DataValoracion;

/**
 * Entity implementation class for Entity: Valoracion
 *
 */
@Entity
@Table(name = "valoraciones")
public class Valoracion implements Serializable {

	// Attributes
	
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	@ManyToOne
	private Jugador jugador;
	
	private Integer valoracion;
	
	@ManyToOne
	private Juego juego;
	
	// Constructors
	
	/*
	 * Default constructor
	 */
	public Valoracion() {
		super();
	}

	/**
	 * Constructor for entity valoracion
	 */
	public Valoracion(Jugador jugador, Integer valoracion, Juego juego) {
		super();
		this.jugador = jugador;
		this.valoracion = valoracion;
		this.juego = juego;
	}

	// Getters
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the jugador
	 */
	public Jugador getJugador() {
		return jugador;
	}

	/**
	 * @return the valoracion
	 */
	public Integer getValoracion() {
		return valoracion;
	}

	/**
	 * @return the juego
	 */
	public Juego getJuego() {
		return juego;
	}

	// Setters
	
	/**
	 * @param jugador the jugador to set
	 */
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	/**
	 * @param valoracion the valoracion to set
	 */
	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}

	/**
	 * @param juego the juego to set
	 */
	public void setJuego(Juego juego) {
		this.juego = juego;
	}
   
	// Methods
	
	/*
	 * Returns a DataType with the information of the entity Valoracion
	 */
	public DataValoracion darDatos() {
		return new DataValoracion(id, this.jugador.getId(), valoracion, this.juego.getId());
	}
}
