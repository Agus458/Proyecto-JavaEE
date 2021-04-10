package model.DataTypes;



public class DataUsuario {

	// Attributes
	
	private Integer id;
	private String nombre;
	private String apellido;
	private Integer edad;
	private String email;
	private String password;

	// Constructor
	
	/**
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param edad
	 * @param email
	 * @param password
	 */
	public DataUsuario(Integer id, String nombre, String apellido, Integer edad, String email, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.email = email;
		this.password = password;
	}
	
	// Getters

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

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
	 * @return the edad
	 */
	public Integer getEdad() {
		return edad;
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

}
