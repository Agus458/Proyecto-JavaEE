package controllers;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Carrito;
import model.Compra;
import model.Jugador;
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
		if(idJugador != null) {
			
			Jugador jugador = usuarioPersistence.buscarJugadorId(idJugador);
			if(jugador != null) {
				Carrito carrito = jugador.getCarrito();
				if( carrito != null && !carrito.estaVacio() && jugador.getSaldo() >= carrito.darSubTotal()) {
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

}
