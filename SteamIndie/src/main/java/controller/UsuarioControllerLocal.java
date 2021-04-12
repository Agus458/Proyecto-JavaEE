package controller;

import java.util.List;

import javax.ejb.Local;

import model.DataTypes.DataUsuario;

@Local
public interface UsuarioControllerLocal {
	
	public Boolean emailEnUso(String email);
	
	public Boolean nickEnUso(String nick);
	
	public void registrarJugador(DataUsuario du);
	
	public List<DataUsuario> listarUsuarios();
	
}
