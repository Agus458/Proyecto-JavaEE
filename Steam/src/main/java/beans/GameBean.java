package beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class GameBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id="1";
	private String nombre="Among Us";
	private String desc="An online and local party game of teamwork and betrayal for 4-10 players...in space!";
	private String imagen="https://www.eneba.com/blog/wp-content/uploads/2020/09/Among-Us-1.jpg";
	private int precio=120;
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	
}
