package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import data_types.DataCategoria;
import data_types.DataJuego;

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

	@ManyToMany
	private List<Categoria> categorias;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Media media;

	@OneToOne
	private Publicacion publicacion;

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
	public Juego(String nombre, String descripcion, Float precio, Media media, List<Categoria> categorias) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.media = media;
		this.publicacion = null;
		this.categorias = categorias;
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

	// Methods

	public DataJuego darDatos() {
		List<DataCategoria> cats = new ArrayList<DataCategoria>();
		for (Categoria aux : this.categorias) {
			cats.add(aux.darDatos());
		}

		return new DataJuego(this.id, this.nombre, this.descripcion, this.precio, cats, this.media.darDatos(),
				this.publicacion.darDatos());
	}

	public void agregarCategoria(Categoria categoria) {
		if (categoria != null) {
			this.categorias.add(categoria);
		}
	}
}
