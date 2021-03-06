package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import data_types.DataPost;
import enums.TipoPost;

/**
 * Entity implementation class for Entity: Post
 *
 */
@Entity
@Table(name = "posts")
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "TEXT")
	private String contenido;
	
	@Column(columnDefinition = "TEXT")
	private String texto;
	
	private TipoPost tipo;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@ManyToOne
	private Jugador jugador;

	public Post() {
		super();
	}

	/**
	 * @param contenido
	 * @param tipo
	 */
	public Post(String contenido, String texto, TipoPost tipo, Jugador jugador) {
		super();
		this.contenido = contenido;
		this.texto = texto;
		this.tipo = tipo;
		this.fecha = new Date();
		this.jugador = jugador;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the contenido
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * @return the tipo
	 */
	public TipoPost getTipo() {
		return tipo;
	}

	/**
	 * @param contenido the contenido to set
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoPost tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
   
	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public DataPost darDatos() {
		return new DataPost(id, contenido, texto, tipo, fecha);
	}
}
