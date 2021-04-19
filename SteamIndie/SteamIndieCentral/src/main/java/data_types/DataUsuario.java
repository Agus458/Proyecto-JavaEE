package data_types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataUsuario {

	// Atributes

	private String nombre;

	private String apellido;

	private String email;

	private String password;

	private String nickname;

	// Constructors
	
	/*
	 * Default Constructor
	 */
	public DataUsuario() {
	}

	/**
	 * Constructor para un DataType de Usuario
	 * @param nombre
	 * @param apellido
	 * @param email
	 * @param password
	 * @param nickname
	 */
	public DataUsuario(String nombre, String apellido, String email, String password, String nickname) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
	}

	// Getters
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}
	
}
