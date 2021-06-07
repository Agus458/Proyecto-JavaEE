package persistence;

import java.util.List;

import javax.ejb.Local;

import data_types.DataCategoria;
import data_types.DataTag;
import model.Categoria;
import model.Tag;

@Local
public interface CategoriaDAO {

	public Categoria insertarCategoria(DataCategoria categoria);

	public List<Categoria> listarCategorias();

	public Categoria buscarCategoriaId(Integer id);

	public Categoria buscarCategoriaNombre(String nombre);

	public Tag insertarTag(DataTag tag);

	public List<Tag> listarTags();

	public Tag buscarTagId(Integer id);

	public Tag buscarTagNombre(String nombre);

}
