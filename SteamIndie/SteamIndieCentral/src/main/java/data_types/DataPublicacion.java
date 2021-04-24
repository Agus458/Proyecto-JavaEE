/**
 * 
 */
package data_types;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @author Agustín
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataPublicacion {

	// Attributes
	
	private Integer id;
	
	private Integer creador;
	
	private Integer juego;
	
	private Date fechaPublicacion;
	
	// Constructors
	
	/**
	 * Default constructor
	 */
	public DataPublicacion() {
		
	}

	/**
	 * Constructor for DataType Publicacion
	 * @param id
	 * @param creador
	 * @param juego
	 * @param fechaPublicacion
	 */
	public DataPublicacion(Integer id, Integer creador, Integer juego, Date fechaPublicacion) {
		super();
		this.id = id;
		this.creador = creador;
		this.juego = juego;
		this.fechaPublicacion = fechaPublicacion;
	}

	// Getters
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the creador
	 */
	public Integer getCreador() {
		return creador;
	}

	/**
	 * @return the juego
	 */
	public Integer getJuego() {
		return juego;
	}

	/**
	 * @return the fechaPublicacion
	 */
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

}
