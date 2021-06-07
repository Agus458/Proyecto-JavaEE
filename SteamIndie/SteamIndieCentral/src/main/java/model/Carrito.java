package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.*;

import data_types.DataCarrito;
import data_types.DataJuego;

/**
 * Entity implementation class for Entity: Carrito
 *
 */
@Entity
@Table(name = "carritos")
public class Carrito implements Serializable {

	// Atributos

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany
	private List<Juego> juegos;

	@OneToOne
	private Jugador jugador;

	// Constructores

	/*
	 * Default constructor
	 */
	public Carrito() {
		super();
	}

	/**
	 * Constructor del carrito
	 * 
	 * @param jugador
	 */
	public Carrito(Jugador jugador) {
		super();
		this.jugador = jugador;
		this.juegos = new ArrayList<Juego>();
	}

	// Getters

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the juegos
	 */
	public List<Juego> getJuegos() {
		return juegos;
	}

	/**
	 * @return the jugador
	 */
	public Jugador getJugador() {
		return jugador;
	}

	// Setters

	/**
	 * @param juegos the juegos to set
	 */
	public void setJuegos(List<Juego> juegos) {
		this.juegos = juegos;
	}

	/**
	 * @param jugador the jugador to set
	 */
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	// Methods

	public DataCarrito darDatos() {
		List<DataJuego> games = new ArrayList<DataJuego>();
		for (Juego aux : this.juegos) {
			games.add(aux.darDatos());
		}
		return new DataCarrito(this.id, games, this.jugador.getId());
	}

	/*
	 * Agregar un juego al carrito
	 */
	public void agregarJuego(Juego juego) {
		if (juego != null) {
			this.juegos.add(juego);
		}
	}

	/*
	 * Remover un juego del carrito
	 */
	public void removerJuego(Juego juego) {
		if (juego != null) {
			Iterator<Juego> itr = juegos.iterator();
			while (itr.hasNext()) {
				Juego aux = itr.next();
				if (aux.getId() == juego.getId()) {
					itr.remove();
				}
			}
		}
	}

	/*
	 * Retorna true si el juego se encuentra en el carrito
	 */
	public Boolean estaElJuego(Juego juego) {
		Boolean esta = false;

		if (juego != null) {
			for (Juego aux : juegos) {
				if (aux.getId() == juego.getId()) {
					esta = true;
				}
			}
		}

		return esta;
	}

	public Boolean estaVacio() {
		return this.juegos.isEmpty();
	}

	public Float darSubTotal() {
		Float subTotal = new Float(0);

		for (Juego aux : this.juegos) {
			subTotal += aux.getPrecioFinal();
		}

		return subTotal;
	}

	public void vaciar() {
		Iterator<Juego> itr = this.juegos.iterator();
		while(itr.hasNext()) {
			itr.next();
			itr.remove();
		}
	}
}
