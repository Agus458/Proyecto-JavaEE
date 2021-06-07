package data_types;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import enums.EstadoOferta;

/*
 * DataType para la entiad oferta
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataOferta {

	// Atributos
	
	private Integer id;
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	private String nombre;
	
	private Float descuento;
	
	private List<Integer> juegos;
	
	private EstadoOferta estado;
	
	// Constructores
	
	/*
	 * Constructr por defecto
	 */
	public DataOferta() {
	}

	/**
	 * Constructor para el DataType Oferta
	 */
	public DataOferta(Integer id, Date fechaInicio, Date fechaFin, String nombre, Float descuento,
			List<Integer> juegos, EstadoOferta estado) {
		super();
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.nombre = nombre;
		this.descuento = descuento;
		this.juegos = juegos;
		this.estado = estado;
	}

	// Getters
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the descuento
	 */
	public Float getDescuento() {
		return descuento;
	}

	/**
	 * @return the juegos
	 */
	public List<Integer> getJuegos() {
		return juegos;
	}

	/**
	 * @return the estado
	 */
	public EstadoOferta getEstado() {
		return estado;
	}
	
}
