package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import data_types.DataOferta;
import enums.EstadoOferta;
import model.Juego;
import model.Oferta;
import persistence.JuegoDAO;
import persistence.JuegoDAOImp;
import persistence.OfertaDAO;

/**
 * Session Bean implementation class ControllerOfertaImp
 */
@Stateless
public class ControllerOfertaImp implements ControllerOferta {

	@EJB
	private OfertaDAO ofertaPersistence = Fabric.getOfertaDAO();
	
	@EJB
	private JuegoDAO juegoPersistence = new JuegoDAOImp();

	/**
	 * Default constructor.
	 */
	public ControllerOfertaImp() {
	}

	/**
	 * Crea una nueva oferta
	 * 
	 * @param nombre    de la oferta,
	 * @param fechaIni  fecha de inicio,
	 * @param fechaFin  fecha de finalizacion,
	 * @param descuento de la oferta
	 */
	@Override
	public void crearOferta(String nombre, Date fechaInicio, Date fechaFin, Float descuento) {
		if (nombre != null && fechaInicio != null && fechaFin != null && fechaInicio.before(fechaFin) && descuento != null && descuento > 0
				&& descuento <= 100) {

			Oferta oferta = ofertaPersistence.buscarNombre(nombre);
			if (oferta == null) {
				if (this.validarFechas(fechaInicio, fechaFin)) {
					oferta = new Oferta(fechaInicio, fechaFin, nombre, descuento);
					ofertaPersistence.guardar(oferta);

					TimerTask taskIni = new TimerTask() {

						@Override
						public void run() {
							alIniciar(nombre);
						}

					};

					TimerTask taskFin = new TimerTask() {

						@Override
						public void run() {
							alFinalizar(nombre);
						}

					};

					Timer timer = new Timer();
					timer.schedule(taskIni, fechaInicio);
					timer.schedule(taskFin, fechaFin);

				}
			}
		}
	}

	@Override
	public Boolean validarFechas(Date fechaInicio, Date fechaFin) {
		
		if(!fechaInicio.after(new Date())) {
			return false;
		}
		
		if(!fechaFin.after(fechaInicio)) {
			return false;
		}
		
		List<Oferta> ofertas = this.ofertaPersistence.darOfertas();
		for(Oferta aux : ofertas) {
			if(fechaInicio.after(aux.getFechaInicio()) && fechaInicio.before(aux.getFechaFin()) || fechaFin.after(aux.getFechaInicio()) && fechaFin.before(aux.getFechaFin())) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public void agregarJuegosOferta(Integer idOferta, List<Integer> idJuegos) {
		if(idJuegos != null && !idJuegos.isEmpty() && idOferta != null) {
			
			Oferta oferta = ofertaPersistence.buscarId(idOferta);
			if(oferta != null && oferta.getEstado() == EstadoOferta.PENDIENTE) {
				
				List<Juego> juegos = new ArrayList<Juego>();
				
				for(Integer i : idJuegos) {
					Juego aux = juegoPersistence.buscarJuegoId(i);
					if(aux != null && aux.getPrecio() > 0 && !oferta.estaEnOferta(aux)) {
						juegos.add(aux);
					}
				}
				
				for(Juego aux : juegos) {
					oferta.agregarJuego(aux);
				}
				System.out.println(oferta.getJuegos().size());
				ofertaPersistence.actualizar(oferta);
			}
			
		}
	}
	
	@Override
	public void removerJuegosOferta(Integer idOferta, List<Integer> idJuegos) {
		if(idJuegos != null && !idJuegos.isEmpty() && idOferta != null) {
			
			Oferta oferta = ofertaPersistence.buscarId(idOferta);
			if(oferta != null && oferta.getEstado() == EstadoOferta.PENDIENTE) {
				
				List<Juego> juegos = new ArrayList<Juego>();
				
				for(Integer i : idJuegos) {
					Juego aux = juegoPersistence.buscarJuegoId(i);
					if(aux != null && oferta.estaEnOferta(aux)) {
						juegos.add(aux);
					}
				}
				
				for(Juego aux : juegos) {
					oferta.removerJuego(aux);
				}
				
				ofertaPersistence.actualizar(oferta);
			}
			
		}
	}
	
	private void alIniciar(String nombre){
		Oferta oferta = this.ofertaPersistence.buscarNombre(nombre);
		if(oferta != null) {
			System.out.println(oferta.getJuegos().size());
			for(Juego aux : oferta.getJuegos()) {
				aux.setPrecioFinal(aux.getPrecio() - ((oferta.getDescuento() * aux.getPrecio()) / 100));
				this.juegoPersistence.update(aux);
			}
			oferta.setEstado(EstadoOferta.ACTIVA);
			this.ofertaPersistence.actualizar(oferta);
		}
	}
	
	private void alFinalizar(String nombre){
		Oferta oferta = this.ofertaPersistence.buscarNombre(nombre);
		if(oferta != null) {
			for(Juego aux : oferta.getJuegos()) {
				aux.setPrecioFinal(aux.getPrecio());
				this.juegoPersistence.update(aux);
			}
			oferta.setEstado(EstadoOferta.FINALIZADA);
			this.ofertaPersistence.actualizar(oferta);
		}
	}
	
	@Override
	public List<DataOferta> darOfertasPendientes() {
		List<DataOferta> res = new ArrayList<DataOferta>();
		List<Oferta> ofertas = this.ofertaPersistence.darOfertasPendientes();
			for(Oferta aux : ofertas) {
				res.add(aux.darDatos());
			}
		return res;
	}

	@Override
	public List<DataOferta> listarOfertas() {
		List<DataOferta> res = new ArrayList<DataOferta>();
		List<Oferta> ofertas = this.ofertaPersistence.darOfertas();
			for(Oferta aux : ofertas) {
				res.add(aux.darDatos());
			}
		return res;
	}
}
