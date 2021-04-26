package data_types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/*
 * DataType for Detalle
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataDetalle {

	// Attributes
	
	private Integer idJuego;
	
	private Float precio;
	
	// Constructors
	
	/*
	 * Default constructor
	 */
	public DataDetalle() {
		
	}

	/*
	 * Constructor for DataType Detalle
	 */
	public DataDetalle(Integer idJuego, Float precio) {
		super();
		this.idJuego = idJuego;
		this.precio = precio;
	}

	// Getters
	
	/**
	 * @return the idJuego
	 */
	public Integer getIdJuego() {
		return idJuego;
	}

	/**
	 * @return the precio
	 */
	public Float getPrecio() {
		return precio;
	}
	
}
