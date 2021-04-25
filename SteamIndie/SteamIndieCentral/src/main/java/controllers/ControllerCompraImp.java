package controllers;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Jugador;
import persistence.UsuarioDAO;

/**
 * Session Bean implementation class ControllerCompraImp
 */
@Stateless
public class ControllerCompraImp implements ControllerCompra {

	@EJB
	private UsuarioDAO usuarioPersistence = Fabric.getUsuarioPersistence();
	
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
				if(jugador.getCarrito() != null && !jugador.getCarrito().estaVacio()) {
					System.out.println("entra");
				}
			}
		}
	}

}
