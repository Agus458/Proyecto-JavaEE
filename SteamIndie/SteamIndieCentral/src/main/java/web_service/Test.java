package web_service;

import java.util.List;

import controllers.ControllerUsuario;
import controllers.Fabric;
import data_types.DataCreador;
import data_types.DataJugador;
import data_types.DataUsuario;

public class Test {

	public Test() {
	}

	public static void main(String[] args) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
//		DataJugador jugador = new DataJugador(null, "Mauricio", "Camacho", "oci@gmail.com", "123", "Oci");
//		controller.registrarJugador(jugador);
//		DataCreador creador = new DataCreador(null, "Agustin", "Peraza", "jglhadkdjfhdsa", "123", "Agu", null);
//		controller.registrarCreador(creador);
//		System.out.println(controller.buscarUsuarioNick(jugador.getNickname()).getApellido());
//		System.out.println(controller.buscarUsuarioNick(creador.getNickname()).getApellido());
//		System.out.println(controller.buscarUsuarioId(2).getApellido());
		
//		List<DataUsuario> usu = controller.listarUsuarios();
//		for(DataUsuario aux : usu) {
//			System.out.println(aux.getId());
//		}
		
	}

}
