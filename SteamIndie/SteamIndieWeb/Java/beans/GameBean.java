package beans;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import web_service.DataCategoria;
import web_service.DataJuego;
import web_service.DataMedia;
import web_service.SteamIndie;
import web_service.SteamIndieImpPortBindingStub;
import web_service.SteamIndieImpService;
import web_service.SteamIndieImpServiceLocator;

@ManagedBean
@ViewScoped
public class GameBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id=1;
	private String nombre="";
	private String desc="";
	private String logo="";
	private String video="";
	private float precio=0;
	
	DataJuego dataJuego = new DataJuego(null,null,null,null,null,null,null);
	
	private List<String> categoriasElegidas = new ArrayList<String>();
	private List<DataCategoria> categoriasDisponibles = new ArrayList<DataCategoria>();
	private String categoria="";
	
	
	@ManagedProperty(value="#{sesionBean}")
		private SesionBean session;

	private String imagen="";
	private List<String> imagenes = new ArrayList<String>();
	private List<String> imagenesAlojadas = new ArrayList<String>();
	
	
	public GameBean() throws MalformedURLException, NumberFormatException, RemoteException{
		HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();	
		String idRequest = origRequest.getParameter("id");
		

		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		
		for(DataCategoria c :  ws.listarCategorias()) {
			categoriasDisponibles.add(c);
		}
		if(idRequest!=null) {
			dataJuego = ws.buscarJuegoId(Integer.parseInt(idRequest));
		}
	}
	
	public String publicarJuego() throws MalformedURLException, RemoteException{	
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		
		DataCategoria[] arregloCategoria = new DataCategoria[categoriasElegidas.size()];
		String[] arregloImagenes = new String[imagenes.size()];
		Integer i = 0;
		for(String c: categoriasElegidas) {
			arregloCategoria[i] = new DataCategoria(null,c);
			i++;
		}
		i=0;
		for(String c: imagenes) {
			System.out.println(i);
			arregloImagenes[i] = c;
			i++;
		}
		DataMedia media = new DataMedia(null, logo , null, arregloImagenes);
		
		DataJuego juego = new DataJuego(null, nombre, desc, precio, arregloCategoria ,media, null);
		
		
		
		ws.publicarJuego(juego,session.getUsuario().getId());
		
		
		return "index";
	}
		
	public void agregarCategoria(){
		categoriasDisponibles.add(new DataCategoria(null, categoria));
		categoria="";
	}
	
	public void agregarImagen(){
		imagenes.add(imagen);
		imagen="";
	}
	
	public DataJuego getDataJuego(){

		return dataJuego;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setDataJuego(DataJuego dataJuego) {
		this.dataJuego = dataJuego;
	}

	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}

	public SesionBean getSession() {
		return session;
	}

	public void setSession(SesionBean session) {
		this.session = session;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public List<String> getCategoriasElegidas() {
		return categoriasElegidas;
	}

	public void setCategoriasElegidas(List<String> categoriasElegidas) {
		this.categoriasElegidas = categoriasElegidas;
	}

	public List<DataCategoria> getCategoriasDisponibles() {
		return categoriasDisponibles;
	}

	public void setCategoriasDisponibles(List<DataCategoria> categoriasDisponibles) {
		this.categoriasDisponibles = categoriasDisponibles;
	}


	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<String> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<String> imagenes) {
		this.imagenes = imagenes;
	}
	
	public List<String> getImagenesAlojadas() {
		return imagenesAlojadas;
	}

	public void setImagenesAlojadas(List<String> imagenesAlojadas) {
		this.imagenesAlojadas = imagenesAlojadas;
	}
	

	
	
	
}