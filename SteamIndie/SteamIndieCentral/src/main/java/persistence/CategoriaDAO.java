package persistence;

import java.util.List;

import javax.ejb.Local;

import data_types.DataCategoria;
import model.Categoria;

@Local
public interface CategoriaDAO {

	public Categoria insertarCategoria(DataCategoria categoria);
	
	public List<Categoria> listarCategorias();
	
	public Categoria buscarCategoriaId(Integer id);
	
	public Categoria buscarCategoriaNombre(String nombre);
	
}
