package web_service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controllers.*;
import data_types.*;

public class Test {

	public Test() {
	}

	public static void main(String[] args) {
		ControllerUsuario controller = Fabric.getControllerUsuario();
//		DataJugador jugador = new DataJugador(null, "Santiago", "Sellanes", "santi@gmail.com", "123", "Santi", null);
//		controller.registrarJugador(jugador);
//		DataCreador creador = new DataCreador(null, "Agustin", "Peraza", "agu@gmail.com", "123", "Agu458", null);
//		controller.registrarCreador(creador);
		DataAdmin admin = new DataAdmin(null, "Admin", "Admin", "admin@admin.com", "123456789", "admin");
		controller.registrarAdmin(admin);
//		System.out.println(controller.buscarUsuarioEmail(admin.getEmail()).getApellido());
//		System.out.println(controller.buscarUsuarioNick(admin.getNickname()).getApellido());
//		System.out.println(controller.buscarUsuarioId(3).getApellido());
//		
//		List<DataUsuario> usu = controller.listarUsuarios();
//		for(DataUsuario aux : usu) {
//			System.out.println(aux.getId());
//		}
//		
		ControllerJuego controllerJuego = Fabric.getControllerJuego();
//		controllerJuego.valorarJuego(5, 1, 1);
//		List<DataCategoria> cats = new ArrayList<DataCategoria>();
//		cats.add(new DataCategoria(null,"Building"));
//		cats.add(new DataCategoria(null,"Rolplay"));
//		DataMedia media = new DataMedia(null, "https://cdn2.unrealengine.com/16br-agentjonesy-egs-s2-1200x1600-1200x1600-2531e05bb04f.jpg", null, null);
//		controllerJuego.publicarJuego(new DataJuego(null, "Minecraft","Make your own world",new Float(30), null,cats,media,null, null,null), 2);
//		
//		List<DataJuego> juegos = controllerJuego.listarJuegos();
//		for(DataJuego aux : juegos) {
//			System.out.println(aux.getNombre());
//			for(DataValoracion val : aux.getValoraciones()) {
//				System.out.println(val.getValoracion());
//			}
//		}
//		
//		controller.agregarJuegoAlCarritoJugador(1, 1);
//		controller.cargarBilleteraJugador(1, new Float(10.0));
//		System.out.println( controller.darSaldoJugador(1));
//		controller.eliminarJuegoDelCarritoJugador(1, 1);
//		for(DataCategoria c : controllerJuego.listarCategorias()) {
//			System.out.println(c.getNombre());
//		}
//		
		ControllerCompra controllerCompra = Fabric.getControllerCompra();
//		controllerCompra.realizarCheckout(1);
//		System.out.println(controllerCompra.darVentasTotalCreador(1));
//		System.out.println(controllerCompra.darVentasTotales());
//		for(DataJuego j:controllerCompra.juegosMasVendidos(1)) {
//			System.out.println(j.getNombre());
//		}
//		System.out.println(controllerCompra.darCantVentasCreador(1));
//		System.out.println(controllerCompra.darCantVentasJuego(1));
		
		ControllerOferta controllerOferta = Fabric.getControllerOferta();
//		controllerOferta.crearOferta("mundo abierto 6", new Date("2021/06/06 17:08"), new Date("2021/06/06 17:10"), new Float(30));
//		List<Integer> juegos = new ArrayList<Integer>();
//		juegos.add(1);
//		controllerOferta.agregarJuegosOferta(3,juegos);
		for(DataOferta o: controllerOferta.darOfertasPendientes()) {
			System.out.println(o.getNombre());
		}
	}

}
