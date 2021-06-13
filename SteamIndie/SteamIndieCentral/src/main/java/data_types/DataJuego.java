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
	
	private Float precioFinal;

	private List<DataCategoria> categorias;
	
	private List<DataTag> tags;
	
	private DataMedia media;
	
	private DataPublicacion publicacion;
	
	private List<DataValoracion> valoraciones;
	
	// Constructors
	
	/*
	 * Default Constructor
	 */
	public DataJuego() {
		
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
	public DataJuego(Integer id, String nombre, String descripcion, Float precio, Float precioFinal, List<DataCategoria> categorias,
			List<DataTag> tags, DataMedia media, DataPublicacion publicacion, List<DataValoracion> valoraciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.precioFinal = precioFinal;
		this.categorias = categorias;
		this.tags = tags;
		this.media = media;
		this.publicacion = publicacion;
		this.valoraciones = valoraciones;
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
	 * @return the tags
	 */
	public List<DataTag> getTags() {
		return tags;
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

	/**
	 * @return the valoraciones
	 */
	public List<DataValoracion> getValoraciones() {
		return valoraciones;
	}

	/**
	 * @return the precioFinal
	 */
	public Float getPrecioFinal() {
		return precioFinal;
	}

}
