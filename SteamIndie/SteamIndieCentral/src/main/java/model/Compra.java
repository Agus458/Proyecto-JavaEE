package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import data_types.DataCompra;

/**
 * Entity implementation class for Entity: Compra
 *
 */
@Entity
@Table(name = "compras")
public class Compra implements Serializable {

	// Attributes
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Jugador jugador;
	
	private Juego juego;
	
	private Float precio;
	
	@Temporal(TemporalType.DATE)
	private Date fechaCompra;
	
	// Constructors
	
	/*
	 * Default constructor
	 */
	public Compra() {
		super();
	}

	/*
	 * Constructor for entity class Compra
	 */
	public Compra(Jugador jugador, Juego juego) {
		super();
		this.jugador = jugador;
		this.juego = juego;
		this.precio = juego.getPrecio();
		this.fechaCompra = new Date();
	}

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

	/**
	 * @return the fechaCompra
	 */
	public Date getFechaCompra() {
		return fechaCompra;
	}

	/**
	 * @param jugador the jugador to set
	 */
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

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

	/**
	 * @param fechaCompra the fechaCompra to set
	 */
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
   
	// Methods
	
	/*
	 * Retorna un DataType Compra with the data
	 */
	public DataCompra darDatos() {
		return new DataCompra(this.id, this.jugador.getId(), this.juego.getId(), this.precio, this.fechaCompra);
	}
}
