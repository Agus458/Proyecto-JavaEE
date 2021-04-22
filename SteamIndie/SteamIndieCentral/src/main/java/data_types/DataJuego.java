package data_types;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataJuego {

	// Atributes
	
	private Integer id;

	private String nombre;

	private String descripcion;

	private Float precio;

	private List<DataCategoria> categorias;
	
	private DataMedia media;
	
	private DataPublicacion publicacion;
	
	// Constructors
	
	/*
	 * Default Constructor
	 */
	public DataJuego() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor for DataType Juego
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param precio
	 * @param categorias
	 * @param media
	 * @param creador
	 */
	public DataJuego(Integer id, String nombre, String descripcion, Float precio, List<DataCategoria> categorias,
			DataMedia media, DataPublicacion publicacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categorias = categorias;
		this.media = media;
		this.publicacion = publicacion;
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

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @return the precio
	 */
	public Float getPrecio() {
		return precio;
	}

	/**
	 * @return the categorias
	 */
	public List<DataCategoria> getCategorias() {
		return categorias;
	}

	/**
	 * @return the media
	 */
	public DataMedia getMedia() {
		return media;
	}

	/**
	 * @return the creador
	 */
	public DataPublicacion getCreador() {
		return publicacion;
	}

}
