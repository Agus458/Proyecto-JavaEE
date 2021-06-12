package persistence;

import java.util.List;

import javax.ejb.Local;

import model.Oferta;

@Local
public interface OfertaDAO {

	public void guardar(Oferta oferta);
	
	public void actualizar(Oferta oferta);
	
	public Oferta buscarId(Integer idOferta);
	
	public Oferta buscarNombre(String nombreOferta);
	
	public List<Oferta> darOfertas();

	public List<Oferta> darOfertasPendientes();
	
}
