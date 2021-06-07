package model;

import java.io.Serializable;
import javax.persistence.*;

import data_types.DataTag;

/**
 * Entity implementation class for Entity: Tag
 *
 */
@Entity
@Table(name = "tags")
public class Tag implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributes

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	// Constructors

	/*
	 * Default constructor
	 */
	public Tag() {
		super();
	}

	/*
	 * Constructor for entity class Categoria
	 * 
	 * @param nombre
	 */
	public Tag(String nombre) {
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
	public DataTag darDatos() {
		return new DataTag(this.id, this.nombre);
	}
}
