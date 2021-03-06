package data_types;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import enums.TipoPost;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataPost {

	private Integer id;
	
	private String contenido;
	
	private String texto;
	
	private TipoPost tipo;
	
	private Date fecha;

	/**
	 * 
	 */
	public DataPost() {
		super();
	}

	/**
	 * @param id
	 * @param contenido
	 * @param tipo
	 * @param fecha
	 */
	public DataPost(Integer id, String contenido, String texto, TipoPost tipo, Date fecha) {
		super();
		this.id = id;
		this.contenido = contenido;
		this.texto = texto;
		this.tipo = tipo;
		this.fecha = fecha;
	}

	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
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
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	
}
