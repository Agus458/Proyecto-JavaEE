/**
 * 
 */
package data_types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @author Agustín
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataCategoria {

	// Attributes
	
	private Integer id;
	
	private String nombre;
	
	// Constructors
	
	/**
	 * Default constructor
	 */
	public DataCategoria() {
	}
	
	

	/**
	 * Constructor for the DataType Categoria
	 * @param nombre
	 */
	public DataCategoria(Integer id, String nombre) {
		super();
		this.id = id;
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

}
