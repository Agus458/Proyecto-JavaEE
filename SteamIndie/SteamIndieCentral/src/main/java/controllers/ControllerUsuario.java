package controllers;

import java.util.List;

import javax.ejb.Local;

import data_types.DataCreador;
import data_types.DataJugador;
import data_types.DataUsuario;

@Local
public interface ControllerUsuario {

	public Boolean emailEnUso(String email);

	public Boolean nickEnUso(String nick);

	public void registrarJugador(DataJugador jugador);
	
	public void registrarCreador(DataCreador creador);

	public List<DataUsuario> listarUsuarios();

	public DataUsuario buscarUsuarioEmail(String email);

	public DataUsuario buscarUsuarioNick(String nick);
	
	public DataUsuario buscarUsuarioId(Integer id);

}
