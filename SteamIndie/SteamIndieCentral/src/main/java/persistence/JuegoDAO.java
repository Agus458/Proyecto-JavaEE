package persistence;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import data_types.DataJuego;
import model.Categoria;
import model.Creador;
import model.Juego;
import model.Publicacion;

@Local
public interface JuegoDAO {

	public Juego insertarJuego(DataJuego juego, List<Categoria> categorias);
	
	public List<Juego> listarJuegos();
	
	public Juego buscarJuegoId(Integer id);
	
	public Juego buscarJuegoNombre(String nombre);
	
	public Publicacion crearPublicacion(Creador creador, Juego juego, Date fechaPublicacion);
	
}
