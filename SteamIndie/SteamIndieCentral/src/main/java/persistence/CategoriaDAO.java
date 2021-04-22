package persistence;

import java.util.List;

import javax.ejb.Local;

import data_types.DataCategoria;

@Local
public interface CategoriaDAO {

	public void insertarCategoria(DataCategoria categoria);
	
	public List<DataCategoria> listarCategorias();
	
	public DataCategoria buscarCategoriaId(Integer id);
	
	public DataCategoria buscarCategoriaNombre(String nombre);
	
}
