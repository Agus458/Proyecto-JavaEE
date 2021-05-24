package data_types;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataComentario {

	// Atributos
	
	private Integer id;
	
	private Integer idJugador;
	
	private Integer idJuego;
	
	private List<DataRespuesta> respuestas;
	
	private String contenido;
	
	private Boolean reportado;
	
	private Date fechaPublicacion;
	
	// Constructores
	
	/*
	 * Constructor por defecto
	 */
	public DataComentario() {
	}

	/*
	 * Constructor para el datatype comentario
	 */
	public DataComentario(Integer id, Integer idJugador, Integer idJuego, List<DataRespuesta> respuestas,
			String contenido, Boolean reportado, Date fechaPublicacion) {
		super();
		this.id = id;
		this.idJugador = idJugador;
		this.idJuego = idJuego;
		this.respuestas = respuestas;
		this.contenido = contenido;
		this.reportado = reportado;
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
	 * @return the jugador
	 */
	public Integer getIdJugador() {
		return idJugador;
	}

	/**
	 * @return the juego
	 */
	public Integer getIdJuego() {
		return idJuego;
	}

	/**
	 * @return the respuestas
	 */
	public List<DataRespuesta> getRespuestas() {
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
	public Boolean getReportado() {
		return reportado;
	}

	/**
	 * @return the fechaPublicacion
	 */
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}
	

}
