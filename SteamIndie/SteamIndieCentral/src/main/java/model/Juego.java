package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import data_types.DataCategoria;
import data_types.DataCreador;
import data_types.DataJuego;
import data_types.DataMedia;
import data_types.DataOferta;
import data_types.DataTag;
import data_types.DataValoracion;

/**
 * Entity implementation class for Entity: Juego
 *
 */
@Entity
@Table(name = "juegos")
public class Juego implements Serializable {

	// Atributes

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	private String descripcion;

	private Float precio;
	
	private Float precioFinal;

	@ManyToMany
	private List<Categoria> categorias;
	
	@ManyToMany
	private List<Tag> tags;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Media media;

	@OneToOne
	private Publicacion publicacion;
	
	@OneToMany(mappedBy = "juego")
	private List<Valoracion> valoraciones;
	
	@OneToMany(mappedBy = "juego")
	private List<Comentario> comentarios;
	
	@ManyToOne
	private Oferta ofertaActual;

	// Constructors

	/*
	 * Default Constructor
	 */
	public Juego() {
		super();
	}

	/**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param precio
	 * @param categorias
	 * @param media
	 * @param creador
	 */
	public Juego(String nombre, String descripcion, Float precio, Media media, List<Categoria> categorias, List<Tag> tags) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.precioFinal = precio;
		this.media = media;
		this.publicacion = null;
		this.categorias = categorias;
		this.tags = tags;
		this.valoraciones = new ArrayList<Valoracion>();
		this.ofertaActual = null;
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
	public List<Categoria> getCategorias() {
		return categorias;
	}
	
	/**
	 * @return the tags
	 */
	public List<Tag> getTags() {
		return tags;
	}

	/**
	 * @return the media
	 */
	public Media getMedia() {
		return media;
	}

	/**
	 * @return the creador
	 */
	public Publicacion getPublicacion() {
		return publicacion;
	}
	
	/**
	 * @return the valoraciones
	 */
	public List<Valoracion> getValoraciones() {
		return valoraciones;
	}
	
	/**
	 * @return the ofertaActual
	 */
	public Oferta getOfertaActual() {
		return ofertaActual;
	}
	
	/**
	 * @return the precioFinal
	 */
	public Float getPrecioFinal() {
		return precioFinal;
	}

	// Setters

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	/**
	 * @param categorias the categorias to set
	 */
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	/**
	 * @param media the media to set
	 */
	public void setMedia(Media media) {
		this.media = media;
	}

	/**
	 * @param publicacion the publicacion to set
	 */
	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}
	
	/**
	 * @param valoraciones the valoraciones to set
	 */
	public void setValoraciones(List<Valoracion> valoraciones) {
		this.valoraciones = valoraciones;
	}

	/**
	 * @param ofertaActual the ofertaActual to set
	 */
	public void setOfertaActual(Oferta ofertaActual) {
		this.ofertaActual = ofertaActual;
	}
	
	/**
	 * @param precioFinal the precioFinal to set
	 */
	public void setPrecioFinal(Float precioFinal) {
		this.precioFinal = precioFinal;
	}
	

	// Methods

	public DataJuego darDatos() {
		List<DataCategoria> cats = new ArrayList<DataCategoria>();
		for (Categoria aux : this.categorias) {
			cats.add(aux.darDatos());
		}
		
		List<DataTag> tas = new ArrayList<DataTag>();
		for (Tag aux : this.tags) {
			tas.add(aux.darDatos());
		}

		DataMedia dataMedia = null;
		if (this.media != null) {
			dataMedia = this.media.darDatos();
		}
		
		List<DataValoracion> vals = new ArrayList<DataValoracion>();
		for(Valoracion aux : this.valoraciones) {
			vals.add(aux.darDatos());
		}
		
		DataOferta oferta = null;
		if(ofertaActual != null) {
			oferta = ofertaActual.darDatos();
		}
		
		return new DataJuego(this.id, this.nombre, this.descripcion, this.precio, this.precioFinal, cats, tas, dataMedia,
				this.publicacion.darDatos(), vals, oferta);
	}

	public void agregarCategoria(Categoria categoria) {
		if (categoria != null) {
			this.categorias.add(categoria);
		}
	}
	
	public DataCreador darCreador() {
		return this.publicacion.getCreador().darDatos();
	}
	
	public Valoracion darValoracionJugador(Jugador jugador) {
		if(jugador != null) {
			for(Valoracion aux : this.valoraciones) {
				if(aux.getJugador().getId() == jugador.getId()) {
					return aux;
				}
			}
		}
		
		return null;
	}
	
	public void agregarValoracion(Valoracion valoracion) {
		if(valoracion != null) {
			this.valoraciones.add(valoracion);
		}
	}

	public void agregarComentario(Comentario comentario) {
		if(comentario != null) {
			this.comentarios.add(comentario);
		}
	}
	
	public Boolean tieneComentario(Integer idComentario) {
		for(Comentario aux : this.comentarios) {
			if(aux.getId() == idComentario) {
				return true;
			}
		}
		
		return false;
	}

}
