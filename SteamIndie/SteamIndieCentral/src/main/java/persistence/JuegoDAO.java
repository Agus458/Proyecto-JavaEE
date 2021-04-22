package persistence;

import java.util.List;

import javax.ejb.Local;

import data_types.DataJuego;
import data_types.DataMedia;
import model.Categoria;
import model.Media;

@Local
public interface JuegoDAO {

	public void insertarJuego(DataJuego juego, List<Categoria> categorias);
	
	public List<DataJuego> listarJuegos();
	
	public DataJuego buscarJuegoId(Integer id);
	
	public DataJuego buscarJuegosNombre(String nombre);
	
	public Media insertarMedia(DataMedia media);
	
}
