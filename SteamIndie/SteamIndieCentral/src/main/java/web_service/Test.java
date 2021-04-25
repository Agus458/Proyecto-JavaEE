package web_service;

import java.util.ArrayList;
import java.util.List;

import controllers.*;
import data_types.*;

public class Test {

	public Test() {
	}

	public static void main(String[] args) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
//		DataJugador jugador = new DataJugador(null, "Mauricio", "Camacho", "oci@gmail.com", "123", "Oci");
//		controller.registrarJugador(jugador);
//		DataCreador creador = new DataCreador(null, "Agustin", "Peraza", "jglhadkdjfhdsa", "123", "Agu", null);
//		controller.registrarCreador(creador);
//		System.out.println(controller.buscarUsuarioEmail(jugador.getEmail()).getApellido());
//		System.out.println(controller.buscarUsuarioNick(creador.getNickname()).getApellido());
//		System.out.println(controller.buscarUsuarioId(2).getApellido());
//		
//		List<DataUsuario> usu = controller.listarUsuarios();
//		for(DataUsuario aux : usu) {
//			System.out.println(aux.getId());
//		}
//		
//		ControllerJuego controllerJuego = Fabric.getControllerJuego();
//		List<DataCategoria> cats = new ArrayList<DataCategoria>();
//		cats.add(new DataCategoria(null,"Shooter"));
//		cats.add(new DataCategoria(null,"Building"));
//		cats.add(new DataCategoria(null,"F2P"));
//		DataMedia media = new DataMedia(null, "https://cdn2.unrealengine.com/16br-agentjonesy-egs-s2-1200x1600-1200x1600-2531e05bb04f.jpg", null, null);
//		controllerJuego.publicarJuego(new DataJuego(null, "Among us","bla bla bla",new Float(0),null,null,null), 2);
//		
//		List<DataJuego> juegos = controllerJuego.listarJuegos();
//		for(DataJuego aux : juegos) {
//			System.out.println(aux.getNombre());
//		}
//		
//		controller.agregarJuegoAlCarritoJugador(1, 1);
//		controller.cargarBilleteraJugador(1, new Float(10.0));
//		controller.eliminarJuegoDelCarritoJugador(1, 1);
//		for(DataCategoria c : controllerJuego.listarCategorias()) {
//			System.out.println(c.getNombre());
//		}
//		
		ControllerCompra controllerCompra = Fabric.getControllerCompra();
		controllerCompra.realizarCheckout(1);
	}

}
