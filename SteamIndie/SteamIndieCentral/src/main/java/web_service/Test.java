package web_service;

import controllers.ControllerUsuario;
import controllers.Fabric;
import data_types.DataJugador;

public class Test {

	public Test() {
	}

	public static void main(String[] args) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
		DataJugador jugador = new DataJugador("Mauricio", "Camacho", "oci@gmail.com", "123", "Oci");
		controller.registrarJugador(jugador);
		System.out.println(controller.emailEnUso(jugador.getEmail()));
	}

}
