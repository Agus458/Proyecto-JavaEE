package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import data_types.DataPublicacion;

/**
 * Entity implementation class for Entity: Publicacion
 *
 */
@Entity
@Table(name = "publicaciones")
public class Publicacion implements Serializable {

	// Attributes

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	private Creador creador;

	@OneToOne
	private Juego juego;

	@Temporal(TemporalType.DATE)
	private Date fechaPublicacion;

	// Constructors

	/*
	 * Default Constructor
	 */
	public Publicacion() {
		super();
	}

	/**
	 * Constructor for Publicacion
	 * @param creador
	 * @param juego
	 * @param fechaPublicacion
	 */
	public Publicacion(Creador creador, Juego juego, Date fechaPublicacion) {
		super();
		this.creador = creador;
		this.juego = juego;
		this.fechaPublicacion = fechaPublicacion;
	}

	// Getters
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the creador
	 */
	public Creador getCreador() {
		return creador;
	}

	/**
	 * @return the juego
	 */
	public Juego getJuego() {
		return juego;
	}

	/**
	 * @return the fechaPublicacion
	 */
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	// Setters
	
	/**
	 * @param creador the creador to set
	 */
	public void setCreador(Creador creador) {
		this.creador = creador;
	}

	/**
	 * @param juego the juego to set
	 */
	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	/**
	 * @param fechaPublicacion the fechaPublicacion to set
	 */
	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	// Methods
	public DataPublicacion darDatos() {
		return new DataPublicacion(this.id, this.creador.getId(), this.juego.getId(), fechaPublicacion);
	}
}
