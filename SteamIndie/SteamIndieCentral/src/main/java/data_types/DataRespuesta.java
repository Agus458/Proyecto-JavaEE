package data_types;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataRespuesta {

private Integer id;
	
	private DataJugador jugador;
	
	private String contenido;
	
	private Integer idComentario;
	
	private Date fechaPublicacion;
	
	public DataRespuesta() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param jugador
	 * @param contenido
	 * @param idComentario
	 * @param fechaPublicacion
	 */
	public DataRespuesta(Integer id, DataJugador jugador, String contenido, Integer idComentario,
			Date fechaPublicacion) {
		super();
		this.id = id;
		this.jugador = jugador;
		this.contenido = contenido;
		this.idComentario = idComentario;
		this.fechaPublicacion = fechaPublicacion;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the jugador
	 */
	public DataJugador getJugador() {
		return jugador;
	}

	/**
	 * @return the contenido
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * @return the idComentario
	 */
	public Integer getIdComentario() {
		return idComentario;
	}

	/**
	 * @return the fechaPublicacion
	 */
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}
	
}
