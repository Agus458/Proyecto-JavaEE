/**
 * 
 */
package data_types;

import java.util.List;

/*
 * DataType implementation for Carrito
 */
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
		// TODO Auto-generated constructor stub
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
