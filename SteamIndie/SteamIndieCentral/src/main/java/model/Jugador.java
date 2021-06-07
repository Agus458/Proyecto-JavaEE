package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import data_types.DataCarrito;
import data_types.DataJugador;
import data_types.DataPost;
import enums.TipoPost;

/**
 * Entity implementation class for Entity: Jugador
 *
 */
@Entity
@Table(name = "jugadores")
public class Jugador extends Usuario implements Serializable {

	// Attributes

	private static final long serialVersionUID = 1L;

	private Float saldo;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Carrito carrito;

	@OneToMany
	private List<Compra> compras;

	@OneToMany
	private List<Juego> juegos;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Post> posts;

	// Constructors

	/*
	 * Default constructor
	 */
	public Jugador() {
		super();
	}

	/**
	 * Constructor for the entity class Jugador
	 * 
	 * @param nombre
	 * @param apellido
	 * @param email
	 * @param password
	 * @param nickname
	 */
	public Jugador(String nombre, String apellido, String email, String password, String nickname) {
		super(nombre, apellido, email, password, nickname);
		this.saldo = new Float(0);
		this.carrito = null;
		this.compras = new ArrayList<Compra>();
		this.juegos = new ArrayList<Juego>();
		this.posts = new ArrayList<Post>();
	}

	// Getters

	/**
	 * @return the compras
	 */
	public List<Compra> getCompras() {
		return compras;
	}

	/**
	 * @return the juegos
	 */
	public List<Juego> getJuegos() {
		return juegos;
	}

	/**
	 * @return the saldo
	 */
	public Float getSaldo() {
		return saldo;
	}

	/**
	 * @return the carrito
	 */
	public Carrito getCarrito() {
		return carrito;
	}

	// Setters

	/**
	 * @param compras the compras to set
	 */
	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	/**
	 * @param juegos the juegos to set
	 */
	public void setJuegos(List<Juego> juegos) {
		this.juegos = juegos;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	/**
	 * @param carrito the carrito to set
	 */
	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	/**
	 * @return the muro
	 */
	public List<Post> getPosts() {
		return posts;
	}

	/**
	 * @param muro the muro to set
	 */
	public void setMuro(List<Post> posts) {
		this.posts = posts;
	}

	// Methods

	public DataJugador darDatos() {
		List<DataPost> p = new ArrayList<DataPost>();
		for(Post aux : this.posts) {
			p.add(aux.darDatos());
		}
		
		return new DataJugador(this.getId(), this.getNombre(), this.getApellido(), this.getEmail(), this.getPassword(),
				this.getNickname(), p);
	}

	public DataCarrito darDatosCarrito() {
		if (this.carrito != null) {
			return this.carrito.darDatos();
		}
		return null;
	}

	public void agregarAlCarrito(Juego juego) {
		if (this.carrito != null) {
			if (!this.carrito.estaElJuego(juego)) {
				this.carrito.agregarJuego(juego);
			}
		} else {
			this.carrito = new Carrito(this);
			this.carrito.agregarJuego(juego);
		}
	}

	public Carrito removerJuegoCarrito(Juego juego) {
		if (this.carrito != null) {
			if (this.carrito.estaElJuego(juego)) {
				this.carrito.removerJuego(juego);
			}
			return this.carrito;
		}
		return null;
	}

	public Boolean estaEnBiblioteca(Juego juego) {
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

	public void agregarCompra(Compra compra) {
		if (compra != null) {
			for (Detalle aux : compra.getDeatlles()) {
				this.juegos.add(aux.getJuego());
			}
			this.compras.add(compra);
			this.saldo -= compra.getTotal();
		}
	}

	public void agregarPost(TipoPost tipo, String contenido) {
		if (tipo != null && contenido != null) {
			this.posts.add(new Post(contenido, tipo));
		}
	}

}
