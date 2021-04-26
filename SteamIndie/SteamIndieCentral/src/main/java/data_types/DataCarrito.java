/**
 * 
 */
package data_types;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/*
 * DataType implementation for Carrito
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataCarrito {

	// Atributos
	
	private Integer id;
	
	private List<DataJuego> juegos;
	
	private Integer jugador;
	
	// Constructor
	
	/**
	 * Default constructor
	 */
	public DataCarrito() {
		
	}

	/**
	 * Constructor for DataType Carrito
	 * @param id
	 * @param juegos
	 * @param subTotal
	 * @param jugador
	 */
	public DataCarrito(Integer id, List<DataJuego> juegos, Integer jugador) {
		super();
		this.id = id;
		this.juegos = juegos;
		this.jugador = jugador;
	}
	
	// Getters;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the juegos
	 */
	public List<DataJuego> getJuegos() {
		return juegos;
	}

	/**
	 * @return the jugador
	 */
	public Integer getJugador() {
		return jugador;
	}

}
