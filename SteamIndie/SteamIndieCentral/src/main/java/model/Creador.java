package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import data_types.DataCreador;
import data_types.DataPublicacion;

/**
 * Entity implementation class for Entity: Creador
 *
 */
@Entity
@Table(name = "creadores")
public class Creador extends Usuario implements Serializable {

	// Atributes
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany
	private List<Publicacion> publicaciones;
	
	// Constructors
	
	/*
	 * Default constructor
	 */
	public Creador() {
		super();
	}

	/**
	 * Constructor for entity class Creador
	 * @param nombre
	 * @param apellido
	 * @param email
	 * @param password
	 * @param nickname
	 */
	public Creador(String nombre, String apellido, String email, String password, String nickname) {
		super(nombre, apellido, email, password, nickname);
		this.publicaciones = new ArrayList<Publicacion>();
	}

	// Getters
	
	/**
	 * @return the publicaciones
	 */
	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	// Setters
	
	/**
	 * @param publicaciones the publicaciones to set
	 */
	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}
   
	// Methods
	
	public DataCreador darDatos() {
		List<DataPublicacion> pubs = new ArrayList<DataPublicacion>();
		
		for(Publicacion aux : this.publicaciones) {
			pubs.add(aux.darDatos());
		}
		
		return new DataCreador(this.getId(), this.getNombre(), this.getApellido(), this.getEmail(), this.getPassword(), this.getNickname(), pubs);
	}
	
	/*
	 * Adds a publication into the creators collection
	 */
	public void agregarPublicacion(Publicacion publicacion) {
		if(publicacion != null) {
			publicaciones.add(publicacion);
		}
	}
}
