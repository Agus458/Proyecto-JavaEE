package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import data_types.DataRespuesta;

/**
 * Entity implementation class for Entity: Respuesta
 *
 */
@Entity
@Table(name = "respuestas")
public class Respuesta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Jugador jugador;
	
	private String contenido;
	
	@ManyToOne
	private Comentario comentario;
	
	@Temporal(TemporalType.DATE)
	private Date fechaPublicacion;
	
	public Respuesta() {
		super();
	}

	/**
	 * @param jugador
	 * @param contenido
	 * @param comentario
	 */
	public Respuesta(Jugador jugador, String contenido, Comentario comentario) {
		super();
		this.jugador = jugador;
		this.contenido = contenido;
		this.comentario = comentario;
		this.fechaPublicacion = new Date();
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
	public Jugador getJugador() {
		return jugador;
	}

	/**
	 * @return the contenido
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * @return the comentario
	 */
	public Comentario getComentario() {
		return comentario;
	}

	/**
	 * @return the fechaPublicacion
	 */
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	/**
	 * @param jugador the jugador to set
	 */
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	/**
	 * @param contenido the contenido to set
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	/**
	 * @param fechaPublicacion the fechaPublicacion to set
	 */
	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	
	
	public DataRespuesta darDatos() {
		return new DataRespuesta(id, this.jugador.darDatos(), contenido, this.comentario.getId(), fechaPublicacion);
	}
}
