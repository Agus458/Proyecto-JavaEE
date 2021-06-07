package model;

import java.io.Serializable;
import javax.persistence.*;

import data_types.DataDetalle;

/**
 * Entity implementation class for Entity: Detalle
 *
 */
@Entity
@Table(name = "detalles")
public class Detalle implements Serializable {

	// Attributes

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Juego juego;

	private Float precio;

	// Constructors

	public Detalle() {
		super();
	}

	/*
	 * Constructor for Detalle
	 */
	public Detalle(Juego juego) {
		super();
		this.juego = juego;
		this.precio = juego.getPrecioFinal();
	}

	// Getters
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the juego
	 */
	public Juego getJuego() {
		return juego;
	}

	/**
	 * @return the precio
	 */
	public Float getPrecio() {
		return precio;
	}

	// Setters

	/**
	 * @param juego the juego to set
	 */
	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	// Methods
	
	public DataDetalle darDatos() {
		return new DataDetalle(this.juego.getId(), this.precio);
	}
	
}
