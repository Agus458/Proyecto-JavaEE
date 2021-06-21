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
import web_service.DataTag;
import web_service.SteamIndie;
import web_service.SteamIndieImpPortBindingStub;
import web_service.SteamIndieImpService;
import web_service.SteamIndieImpServiceLocator;

@ManagedBean
@ViewScoped
public class GameBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//Juego
	private Integer id=1;
	private String nombre="";
	private String desc="";
	private String logo="";
	private float precio=0;
	
	
	//Creador
	DataJuego dataJuego = new DataJuego(null,null,null,null,null,null,null, null,null,null, null);
	
	private List<String> categoriasElegidas = new ArrayList<String>();
	private List<DataCategoria> categoriasDisponibles = new ArrayList<DataCategoria>();
	
	private List<String> tagsElegidas = new ArrayList<String>();
	private List<DataTag> tagsDisponibles = new ArrayList<DataTag>();
	private String tag="";
	
	private String imagen="";
	private List<String> imagenes = new ArrayList<String>();
	private List<String> imagenesAlojadas = new ArrayList<String>();
	

	private String video="";
	private List<String> videos = new ArrayList<String>();
	private List<String> videosAlojadas = new ArrayList<String>();
	
	//Sesion
	@ManagedProperty(value="#{sesionBean}")
		private SesionBean session;
	
	//Valoracion
	private String valoracion="0";
	
	//Imagenes Select
	private String imagenSelect ="";
	private ArrayList<String> imagenesSelect = new ArrayList<String>();

	private String videoSelect ="";
	private ArrayList<String> videosSelect = new ArrayList<String>();
	
	private Boolean esImagen = true;
	
	//Constructor
	public GameBean() throws MalformedURLException, NumberFormatException, RemoteException{
		HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();	
		String idRequest = origRequest.getParameter("id");
		

		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		if(ws.listarCategorias()!=null) {
			for(DataCategoria c :  ws.listarCategorias()) {
				categoriasDisponibles.add(c);
			}
		}

		if(ws.listarTags()!=null) {
			for(DataTag c :  ws.listarTags()) {
				tagsDisponibles.add(c);
			}
		}
		if(idRequest!=null) {
			dataJuego = ws.buscarJuegoId(Integer.parseInt(idRequest));
			if(dataJuego.getId()!=null) {
				if(dataJuego.getMedia().getLogo()!=null) {
					imagenesSelect.add(dataJuego.getMedia().getLogo());
				}
				if(dataJuego.getMedia().getImagenes()!=null) {
					imagenSelect = dataJuego.getMedia().getImagenes(0);
					for(String s : dataJuego.getMedia().getImagenes()) {
						imagenesSelect.add(s);
					}
				}
				if(dataJuego.getMedia().getVideos()!=null) {
	
					for(String s : dataJuego.getMedia().getVideos()) {
						videosSelect.add(s);
					}
				}
			}
		}
	}
	
	//Creador
	public String publicarJuego() throws MalformedURLException, RemoteException{	
		//Definicion Web SEervice
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		
		//Obteniendo Datos
		DataCategoria[] arregloCategoria = new DataCategoria[categoriasElegidas.size()];
		DataTag[] arregloTag = new DataTag[tagsElegidas.size()];
		String[] arregloImagenes = new String[imagenes.size()];		
		String[] arregloVideos = new String[videos.size()];

		Integer i = 0;
		
		//Interprentado los datos
		for(String c: categoriasElegidas) {
			arregloCategoria[i] = new DataCategoria(null,c);
			i++;
		}
		i=0;
		for(String c: tagsElegidas) {
			arregloTag[i] = new DataTag(null,c);
			i++;
		}
		i=0;
		for(String c: imagenes) {
			arregloImagenes[i] = c;
			i++;
		}

		i=0;
		for(String c: videos) {
			arregloVideos[i] = c;
			i++;
		}
		
		//Creacion de los objetos
		DataMedia media = new DataMedia(null, logo , arregloVideos, arregloImagenes);
		
		DataJuego juego = new DataJuego(null, nombre, desc, precio, null, null,arregloCategoria, arregloTag, media, null, null);
		
		
		//Llamada final a persistencia WebService
		ws.publicarJuego(juego,session.getUsuario().getId());
		
		
		//Retorno a Index
		return "index";
	}
		
	public void agregarTags(){
		if(!tag.isEmpty()) {
			tagsDisponibles.add(new DataTag(null,tag));
			tag="";
		}
	}
	
	public void agregarImagen(){
		if(!imagen.isEmpty()) {
			imagenes.add(imagen);
			imagen="";
		}
	}
	

	public void agregarVideo(){
		if(!video.isEmpty()) {
			videos.add(video);
			video="";
		}
	}
	
	//Jugador
	public void valorarJuego() throws RemoteException, MalformedURLException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		
		ws.valorarJuego(Integer.parseInt(valoracion), dataJuego.getId(), session.getUsuario().getId());
	}
	
	//Imagenes Seleccion

	public void cambiarImagen(String img, Boolean esImg) {
		esImagen = esImg;
		this.imagenSelect = img;
	}
	
	
	//Reportar Juego
	public void enviarReporte() throws RemoteException, MalformedURLException {
		SteamIndieImpService servicio = new SteamIndieImpServiceLocator();
		SteamIndie ws = new SteamIndieImpPortBindingStub(new URL(servicio.getSteamIndieImpPortAddress()), servicio);
		
		ws.reportarJuego(dataJuego.getId());

	}
	
	//===================//
	// GETTERS & SETTERS //
	//===================//
	
	
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

	public String getValoracion() {
		return valoracion;
	}

	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}

	public String getImagenSelect() {
		return imagenSelect;
	}

	public void setImagenSelect(String imagenSelect) {
		this.imagenSelect = imagenSelect;
	}

	public ArrayList<String> getImagenesSelect() {
		return imagenesSelect;
	}

	public void setImagenesSelect(ArrayList<String> imagenesSelect) {
		this.imagenesSelect = imagenesSelect;
	}

	public List<String> getVideos() {
		return videos;
	}

	public void setVideos(List<String> videos) {
		this.videos = videos;
	}

	public List<String> getVideosAlojadas() {
		return videosAlojadas;
	}

	public void setVideosAlojadas(List<String> videosAlojadas) {
		this.videosAlojadas = videosAlojadas;
	}

	public String getVideoSelect() {
		return videoSelect;
	}

	public void setVideoSelect(String videoSelect) {
		this.videoSelect = videoSelect;
	}

	public ArrayList<String> getVideosSelect() {
		return videosSelect;
	}

	public void setVideosSelect(ArrayList<String> videosSelect) {
		this.videosSelect = videosSelect;
	}

	public List<String> getTagsElegidas() {
		return tagsElegidas;
	}

	public void setTagsElegidas(List<String> tagsElegidas) {
		this.tagsElegidas = tagsElegidas;
	}

	public List<DataTag> getTagsDisponibles() {
		return tagsDisponibles;
	}

	public void setTagsDisponibles(List<DataTag> tagsDisponibles) {
		this.tagsDisponibles = tagsDisponibles;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Boolean getEsImagen() {
		return esImagen;
	}

	public void setEsImagen(Boolean esImagen) {
		this.esImagen = esImagen;
	}
	
	
	
	
	
}