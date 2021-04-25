/**
 * 
 */
package data_types;

import java.util.Date;

/*
 * DataType implementation for entity Compra
 */
public class DataCompra {

	// Attributes

	private Integer id;

	private Integer jugador;

	private Integer juego;

	private Float precio;

	private Date fechaCompra;

	// Constructors
	
	/*
	 * Constructor for DataType Compra
	 */
	public DataCompra(Integer id, Integer jugador, Integer juego, Float precio, Date fechaCompra) {
		super();
		this.id = id;
		this.jugador = jugador;
		this.juego = juego;
		this.precio = precio;
		this.fechaCompra = fechaCompra;
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
	public Integer getJugador() {
		return jugador;
	}

	/**
	 * @return the juego
	 */
	public Integer getJuego() {
		return juego;
	}

	/**
	 * @return the precio
	 */
	public Float getPrecio() {
		return precio;
	}

	/**
	 * @return the fechaCompra
	 */
	public Date getFechaCompra() {
		return fechaCompra;
	}
	
}
