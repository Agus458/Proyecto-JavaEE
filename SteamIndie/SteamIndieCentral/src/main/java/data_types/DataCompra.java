/**
 * 
 */
package data_types;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/*
 * DataType implementation for entity Compra
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataCompra {

	// Attributes

	private Integer id;

	private Integer jugador;

	private List<DataDetalle> detalles;

	private Float total;

	private Date fechaCompra;

	// Constructors
	
	/*
	 * Constructor for DataType Compra
	 */
	public DataCompra(Integer id, Integer jugador, List<DataDetalle> detalles, Float total, Date fechaCompra) {
		super();
		this.id = id;
		this.jugador = jugador;
		this.detalles = detalles;
		this.total = total;
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
	public List<DataDetalle> getDetalles() {
		return detalles;
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
	
}
