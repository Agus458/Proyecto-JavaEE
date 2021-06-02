package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import data_types.DataJuego;
import data_types.DataPublicacion;
import model.Carrito;
import model.Compra;
import model.Creador;
import model.Detalle;
import model.Juego;
import model.Jugador;
import model.Publicacion;
import persistence.CompraDAO;
import persistence.UsuarioDAO;

/**
 * Session Bean implementation class ControllerCompraImp
 */
@Stateless
public class ControllerCompraImp implements ControllerCompra {

	@EJB
	private UsuarioDAO usuarioPersistence = Fabric.getUsuarioPersistence();

	@EJB
	private CompraDAO compraPersistence = Fabric.getCompraPersistence();
	
	/**
	 * Default constructor.
	 */
	public ControllerCompraImp() {

	}

	@Override
	public void realizarCheckout(Integer idJugador) {
		if (idJugador != null) {

			Jugador jugador = usuarioPersistence.buscarJugadorId(idJugador);
			if (jugador != null) {
				Carrito carrito = jugador.getCarrito();
				if (carrito != null && !carrito.estaVacio() && jugador.getSaldo() >= carrito.darSubTotal()) {
					Compra compra = compraPersistence.insertarCompra(jugador, carrito.getJuegos());
					jugador.agregarCompra(compra);
					jugador.setCarrito(null);
					carrito.vaciar();
					usuarioPersistence.removerCarrito(carrito);
					usuarioPersistence.actualizarJugador(jugador);
				}
			}
		}
	}

	@Override
	public float darVentasTotales() {
		float res = 0;
		List<Compra> compras = compraPersistence.darTodasCompras();

		if (compras != null) {
			for (Compra c : compras) {
				res = res + c.getTotal();
			}

		}

		return res;
	}

	@Override
	public List<DataJuego> juegosMasVendidos() {
		List<Juego> juegos = compraPersistence.masVendidos();
		List<DataJuego> res = new ArrayList<DataJuego>();
		if (juegos != null) {
			for (Juego j : juegos) {
				res.add(j.darDatos());
			}
		}

		return res;
	}
	
	@Override
	public List<DataJuego> juegosMasVendidos(Integer idCreador) {
		List<DataJuego> res = null;
		//Comprobaciones obtencion de datos
		if(idCreador!=null) {
			res = new ArrayList<DataJuego>();
			
			Creador creador = usuarioPersistence.buscarCreadorId(idCreador);
			
			if(creador!=null) {
				List<Juego> juegos = compraPersistence.masVendidos();
				if (juegos != null) {
					//Itero sobre juegos mas vendidos
					for (Juego j : juegos) {
						//Itero sobre publicaciones buscando el juego
						for(Publicacion p: creador.getPublicaciones()) {
							//Comparacion
							if(p.getJuego().getId().equals(j.getId())){
								//Agrego datos y termino la iteracion
								res.add(j.darDatos());
								break;
							}
						}
					}
				}
			}
		}

		return res;
	}

	
	@Override
	public float darVentasTotalCreador(Integer idCreador) {
		float res = 0;
		if(idCreador!=null) {
			Creador creador = usuarioPersistence.buscarCreadorId(idCreador);
			
			if(creador!=null) {
				List<Detalle> detalles = compraPersistence.darTodosDetalles();
				if (detalles != null) {
					//Itero sobre detalles
					for (Detalle d : detalles) {
						//Itero sobre publicaciones buscando el juego
						for(Publicacion p: creador.getPublicaciones()) {
							//Comparacion
							if(p.getJuego().getId().equals(d.getJuego().getId())){
								//Sumo a res y termino la iteracion
								res = res + d.getPrecio();
								break;
							}
						}
					}
				}
			}
		}
		return (float) (res-res*0.1);
		
		
	}
	
	@Override
	public Integer darCantVentasJuego(Integer idJuego) {
		Integer res = 0;
		if(idJuego!=null) {			
			List<Detalle> detalles = compraPersistence.darTodosDetalles();
			if (detalles != null) {
				//Itero sobre detalles
				for (Detalle d : detalles) {
					if(d.getJuego().getId().equals(idJuego)){
						//Sumo a res y termino la iteracion
						res++;
					}
				}
			}			
		}
		
		return res;
	}
	
	@Override
	public Integer darCantVentasCreador(Integer idCreador) {
		Integer res = 0;
		if(idCreador!=null) {
			Creador creador = usuarioPersistence.buscarCreadorId(idCreador);
			
			if(creador!=null) {
				List<Detalle> detalles = compraPersistence.darTodosDetalles();
				if (detalles != null) {
					//Itero sobre detalles
					for (Detalle d : detalles) {
						//Itero sobre publicaciones buscando el juego
						for(Publicacion p: creador.getPublicaciones()) {
							//Comparacion
							if(p.getJuego().getId().equals(d.getJuego().getId())){
								//Sumo a res y termino la iteracion
								res++;
								break;
							}
						}
					}
				}
			}
		}
		return res;
		
	}
}
