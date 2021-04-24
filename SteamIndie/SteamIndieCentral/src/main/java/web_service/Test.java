package web_service;

import java.util.ArrayList;
import java.util.List;

import controllers.ControllerJuego;
import controllers.ControllerUsuario;
import controllers.Fabric;
import data_types.DataCategoria;
import data_types.DataCreador;
import data_types.DataJuego;
import data_types.DataJugador;
import data_types.DataMedia;
import data_types.DataUsuario;

public class Test {

	public Test() {
	}

	public static void main(String[] args) {
//		ControllerUsuario controller = Fabric.getControllerUsuario();
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
//		cats.add(new DataCategoria(null,"F2P"));
//		List<String> img = new ArrayList<String>();
//		img.add("https://cdn2.unrealengine.com/16br-agentjonesy-egs-s2-1200x1600-1200x1600-2531e05bb04f.jpg");
//		img.add("https://cdn2.unrealengine.com/16br-agentjonesy-egs-s2-1200x1600-1200x1600-2531e05bb04f.jpg");
//		DataMedia media = new DataMedia(null, "https://cdn2.unrealengine.com/16br-agentjonesy-egs-s2-1200x1600-1200x1600-2531e05bb04f.jpg", null, img);
//		controllerJuego.publicarJuego(new DataJuego(null, "GTAV","dfjkhdsajfhdslak",new Float(300),cats,media,null), 2);
//		
//		List<DataJuego> juegos = controllerJuego.listarJuegos();
//		for(DataJuego aux : juegos) {
//			System.out.println(aux.getMedia().getLogo());
//		}
	}

}
