package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.*;

import data_types.DataOferta;
import enums.EstadoOferta;

/**
 * Entity implementation class for Entity: Oferta
 *
 */
@Entity
@Table(name = "ofertas")
public class Oferta implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFin;
	
	@Column(unique = true)
	private String nombre;
	
	private Float descuento;
	
	private EstadoOferta estado;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Juego> juegos;
	
	// Constructores
	
	/*
	 * Constructor por defecto para la entidad Oferta
	 */
	public Oferta() {
		super();
	}

	/**
	 * Contructor para la entidad Oferta
	 */
	public Oferta(Date fechaInicio, Date fechaFin, String nombre, Float descuento) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.nombre = nombre;
		this.descuento = descuento;
		this.juegos = new ArrayList<Juego>();
		this.estado = EstadoOferta.PENDIENTE;
	}
	
	// Getters

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the descuento
	 */
	public Float getDescuento() {
		return descuento;
	}

	/**
	 * @return the juegos
	 */
	public List<Juego> getJuegos() {
		return juegos;
	}
	
	/**
	 * @return the estado
	 */
	public EstadoOferta getEstado() {
		return estado;
	}
	
	// Setters

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}

	/**
	 * @param juegos the juegos to set
	 */
	public void setJuegos(List<Juego> juegos) {
		this.juegos = juegos;
	}
	
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoOferta estado) {
		this.estado = estado;
	}

	
	// Metodos
	
	/*
	 * Retorna true si un juego ya esta en oferta
	 */
	public Boolean estaEnOferta(Juego juego) {
		for(Juego aux : this.juegos) {
			if(aux.getId() == juego.getId()) return true;
		}
		return false;
	}
	
	/*
	 * Agrega un juego a la oferta
	 */
	public void agregarJuego(Juego juego) {
		if(juego != null) {
			this.juegos.add(juego);
		}
	}
	
	/*
	 * Remueve un juego a la oferta
	 */
	public void removerJuego(Juego juego) {
		if(juego != null) {
			Iterator<Juego> it = this.juegos.iterator();
			while(it.hasNext()) {
				Juego aux = (Juego) it.next();
				if(aux.getId() == juego.getId()) {
					it.remove();
				}
			}
		}
	}

	/*
	 * Retorna un DataType con los datos de la oferta
	 */
	public DataOferta darDatos() {
		List<Integer> games = new ArrayList<Integer>();
		for(Juego aux : this.juegos) {
			games.add(aux.getId());
		}
		
		return new DataOferta(id, fechaInicio, fechaFin, nombre, descuento, games, estado);
	}
	
}
