package controllers;

import persistence.CategoriaDAO;
import persistence.CategoriaDAOImp;
import persistence.CompraDAO;
import persistence.CompraDAOImp;
import persistence.OfertaDAO;
import persistence.OfertaDAOImp;
import persistence.ReseniaDAO;
import persistence.ReseniaDAOImp;
import persistence.UsuarioDAO;
import persistence.UsuarioDAOImp;

public class Fabric {
	
	public static ControllerUsuario getControllerUsuario() {
		return new ControllerUsuarioImp();
	}

	public static ControllerJuego getControllerJuego() {
		return new ControllerJuegoImp();
	}
	
	public static ControllerCompra getControllerCompra() {
		return new ControllerCompraImp();
	}
	
	public static ControllerOferta getControllerOferta() {
		return new ControllerOfertaImp();
	}
	
	public static UsuarioDAO getUsuarioPersistence() {
		return new UsuarioDAOImp();
	}
	
	public static CategoriaDAO getCategoriaPersistence() {
		return new CategoriaDAOImp();
	}
	
	public static CompraDAO getCompraPersistence() {
		return new CompraDAOImp();
	}
	
	public static ReseniaDAO getReseniaDAO() {
		return new ReseniaDAOImp();
	}
	
	public static OfertaDAO getOfertaDAO() {
		return new OfertaDAOImp();
	}
}
