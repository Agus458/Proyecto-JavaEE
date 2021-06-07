/**
 * 
 */
package data_types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * DataType implementation for Valoracion
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataValoracion {

	// Attributes
	
	private Integer id;
	
	private Integer idJugador;
	
	private Integer Valoracion;
	
	private Integer idJuego;
	
	// Constructors

	/*
	 * Default constructor
	 */
	private DataValoracion() {
	}

	/**
	 * Constructor for DataType for Valoracion
	 */
	public DataValoracion(Integer id, Integer idJugador, Integer valoracion, Integer idJuego) {
		super();
		this.id = id;
		this.idJugador = idJugador;
		Valoracion = valoracion;
		this.idJuego = idJuego;
	}

	// Getters
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the idJugador
	 */
	public Integer getIdJugador() {
		return idJugador;
	}

	/**
	 * @return the valoracion
	 */
	public Integer getValoracion() {
		return Valoracion;
	}

	/**
	 * @return the idJuego
	 */
	public Integer getIdJuego() {
		return idJuego;
	}
	
}
