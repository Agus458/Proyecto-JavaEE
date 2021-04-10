package controller;

import javax.ejb.Local;

import model.DataTypes.DataUsuario;

@Local
public interface UsuarioControllerLocal {
	
	public void registrarUsuario(DataUsuario du);
	
}
