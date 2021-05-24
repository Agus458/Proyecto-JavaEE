package model;

import java.io.Serializable;
import javax.persistence.*;

import data_types.DataAdmin;
import data_types.DataUsuario;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
@Table(name = "admins")
public class Admin extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}
   
	/**
	 * Constructor for Admin class
	 */
	public Admin(String nombre, String apellido, String email, String password, String nickname) {
		super(nombre, apellido, email, password, nickname);
	}

	public DataUsuario darDatos() {
		return new DataAdmin(this.getId(), this.getNombre(), this.getApellido(), this.getEmail(), this.getPassword(), this.getNickname());
	}
}
