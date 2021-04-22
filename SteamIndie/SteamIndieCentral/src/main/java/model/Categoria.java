package model;

import java.io.Serializable;
import javax.persistence.*;

import data_types.DataCategoria;

/**
 * Entity implementation class for Entity: Categoria
 *
 */
@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {

	// Atributes
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	// Constructors
	
	/*
	 * Default constructor
	 */
	public Categoria() {
		super();
	}

	/*
	 * Constructor for entity class Categoria
	 * @param nombre
	 */
	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	// Getters

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	// Setters
	
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// Methods
	
	/*
	 * Returns a DataType with the information of Categoria
	 */
	public DataCategoria darDatos() {
		return new DataCategoria(this.id, this.nombre);
	}
	
}
