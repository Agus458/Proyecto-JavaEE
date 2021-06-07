package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import data_types.DataCompra;
import data_types.DataDetalle;

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

	@ManyToOne
	private Jugador jugador;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Detalle> detalles;
	
	private Float total;
	
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
	public Compra(Jugador jugador, List<Juego> juegos) {
		super();
		this.jugador = jugador;
		this.detalles = new ArrayList<Detalle>();
		this.total = new Float(0);
		for(Juego aux : juegos) {
			detalles.add(new Detalle(aux));
			this.total += aux.getPrecioFinal();
		}
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
	 * @return the detalles
	 */
	public List<Detalle> getDeatlles() {
		return this.detalles;
	}

	/**
	 * @return the precio
	 */
	public Float getTotal() {
		return total;
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
	 * @param detalle the detalle to set
	 */
	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setTotal(Float total) {
		this.total = total;
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
		List<DataDetalle> det = new ArrayList<DataDetalle>();
		for(Detalle aux : this.detalles) {
			det.add(aux.darDatos());
		}
		
		return new DataCompra(this.id, this.jugador.getId(), det, this.total, this.fechaCompra);
	}
}
