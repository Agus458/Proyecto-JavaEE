package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import web_service.DataJuego;

@ManagedBean
@ViewScoped
public class LibraryBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DataJuego juego = null;
	
	public LibraryBean() {
		// TODO Auto-generated constructor stub
	}

	public void viewJuego(DataJuego viewJuego ){
		this.setJuego(viewJuego);
	}
	
	public DataJuego getJuego() {
		return juego;
	}

	public void setJuego(DataJuego juego) {
		this.juego = juego;
	}

	
	
}
