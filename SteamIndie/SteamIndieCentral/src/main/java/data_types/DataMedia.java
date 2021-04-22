package data_types;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataMedia {

	// Attributes
	
	private Integer id;
	
	private List<String> videos;
	
	private List<String> imagenes;
	
	// Constructors
	
	public DataMedia() {
	}

	/**
	 * Constructor for DataType Media
	 * @param videos
	 * @param imagenes
	 */
	public DataMedia(Integer id, List<String> videos, List<String> imagenes) {
		super();
		this.id = id;
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
	
}
