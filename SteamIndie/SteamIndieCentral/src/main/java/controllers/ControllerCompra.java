package controllers;

import javax.ejb.Local;

@Local
public interface ControllerCompra {

	public void realizarCheckout(Integer idJugador);
	
}
