package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import data_types.DataComentario;
import data_types.DataRespuesta;
import enums.EstadoBloqueo;

/**
 * Entity implementation class for Entity: Comentario
 *
 */
@Entity
@Table(name = "comentarios")
public class Comentario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Attributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Jugador jugador;
	
	@ManyToOne
	private Juego juego;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Respuesta> respuestas;
	
	private String contenido;
	
	private Integer reportes;
	
	private EstadoBloqueo estadoBloqueo;
	
	@Temporal(TemporalType.DATE)
	private Date fechaPublicacion;

	// Constructors
	
	/*
	 * Default constructor
	 */
	public Comentario() {
		super();
	}

	/**
	 * Default constructor for a comment
	 */
	public Comentario(Jugador jugador, Juego juego, String contenido) {
		super();
		this.jugador = jugador;
		this.juego = juego;
		this.contenido = contenido;
		this.fechaPublicacion = new Date();
		this.reportes = 0;
		this.respuestas = new ArrayList<Respuesta>();
		this.estadoBloqueo = EstadoBloqueo.NOACTIVO;
	}

	// Getters
	
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
	 * @return the juego
	 */
	public Juego getJuego() {
		return juego;
	}

	/**
	 * @return the respuestas
	 */
	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	/**
	 * @return the contenido
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * @return the reportado
	 */
	public Integer getReportes() {
		return reportes;
	}

	/**
	 * @return the fechaPublicacion
	 */
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}
	
	// Setters

	/**
	 * @param jugador the jugador to set
	 */
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	/**
	 * @param juego the juego to set
	 */
	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	/**
	 * @param respuestas the respuestas to set
	 */
	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	/**
	 * @param contenido the contenido to set
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	/**
	 * @param reportado the reportado to set
	 */
	public void setReportes(Integer reportes) {
		this.reportes = reportes;
	}

	/**
	 * @param fechaPublicacion the fechaPublicacion to set
	 */
	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
   
	// Metodos
	
	public void agregarRespuesta(Respuesta respuesta) {
		if(respuesta != null) {
			this.respuestas.add(respuesta);
		}
	}
	
	public DataComentario darDatos() {
		List<DataRespuesta> responses = new ArrayList<DataRespuesta>();
		for(Respuesta aux : this.respuestas) {
			responses.add(aux.darDatos());
		}
		
		return new DataComentario(this.id, this.jugador.getId(), this.juego.getId(), responses, this.contenido, this.reportes, this.fechaPublicacion);
	}

	public EstadoBloqueo getEstadoBloqueo() {
		return estadoBloqueo;
	}

	public void setEstadoBloqueo(EstadoBloqueo estadoBloqueo) {
		this.estadoBloqueo = estadoBloqueo;
	}
}
