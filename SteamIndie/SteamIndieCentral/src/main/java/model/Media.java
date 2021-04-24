package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import data_types.DataMedia;

/**
 * Entity implementation class for Entity: Media
 *
 */
@Entity
@Table(name = "medias")
public class Media implements Serializable {

	// Attributes
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String logo;
	
	@ElementCollection
	private List<String> videos;
	
	@ElementCollection
	private List<String> imagenes;
	
	// Constructor
	
	/*
	 * Default Constructor
	 */
	public Media() {
		super();
	}

	/**
	 * Constructor for entity class Media
	 * @param videos
	 * @param imagenes
	 */
	public Media(String logo, List<String> videos, List<String> imagenes) {
		super();
		this.logo = logo;
		this.videos = videos;
		this.imagenes = imagenes;
	}

	// Getters
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}
	
	/**
	 * @return the videos
	 */
	public List<String> getVideos() {
		return videos;
	}

	/**
	 * @return the imagenes
	 */
	public List<String> getImagenes() {
		return imagenes;
	}

	// Setters
	
	/**
	 * @param videos the videos to set
	 */
	public void setVideos(List<String> videos) {
		this.videos = videos;
	}

	/**
	 * @param imagenes the imagenes to set
	 */
	public void setImagenes(List<String> imagenes) {
		this.imagenes = imagenes;
	}
	
	/**
	 * @param logo the logo to set
	 */
	public void setImagenes(String logo) {
		this.logo = logo;
	}
   
	// Methods
	
	public DataMedia darDatos() {
		return new DataMedia(this.id, this.logo, this.videos, this.imagenes);
	}
	
}
