package web_service;

public class SteamIndieProxy implements web_service.SteamIndie {
  private String _endpoint = null;
  private web_service.SteamIndie steamIndie = null;
  
  public SteamIndieProxy() {
    _initSteamIndieProxy();
  }
  
  public SteamIndieProxy(String endpoint) {
    _endpoint = endpoint;
    _initSteamIndieProxy();
  }
  
  private void _initSteamIndieProxy() {
    try {
      steamIndie = (new web_service.SteamIndieImpServiceLocator()).getSteamIndieImpPort();
      if (steamIndie != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)steamIndie)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)steamIndie)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (steamIndie != null)
      ((javax.xml.rpc.Stub)steamIndie)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public web_service.SteamIndie getSteamIndie() {
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie;
  }
  
  public web_service.DataJuego[] listarJuegos() throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.listarJuegos();
  }
  
  public web_service.DataJuego buscarJuegoId(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.buscarJuegoId(arg0);
  }
  
  public web_service.DataUsuario buscarUsuarioEmail(java.lang.String arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.buscarUsuarioEmail(arg0);
  }
  
  public java.lang.Boolean nickEnUso(java.lang.String arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.nickEnUso(arg0);
  }
  
  public web_service.DataUsuario buscarUsuarioId(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.buscarUsuarioId(arg0);
  }
  
  public void registrarCreador(web_service.DataCreador arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.registrarCreador(arg0);
  }
  
  public java.lang.Boolean nombreJuegoEnUso(java.lang.String arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.nombreJuegoEnUso(arg0);
  }
  
  public void publicarJuego(web_service.DataJuego arg0, java.lang.Integer arg1) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.publicarJuego(arg0, arg1);
  }
  
  public void registrarJugador(web_service.DataJugador arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.registrarJugador(arg0);
  }
  
  public java.lang.Boolean emailEnUso(java.lang.String arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.emailEnUso(arg0);
  }
  
  public web_service.DataUsuario[] listarUsuarios() throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.listarUsuarios();
  }
  
  public web_service.DataCarrito darDatosCarritoJugador(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.darDatosCarritoJugador(arg0);
  }
  
  public web_service.DataJuego buscarJuegoNombre(java.lang.String arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.buscarJuegoNombre(arg0);
  }
  
  public void agregarJuegoAlCarritoJugador(java.lang.Integer arg0, java.lang.Integer arg1) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.agregarJuegoAlCarritoJugador(arg0, arg1);
  }
  
  public void eliminarJuegoDelCarritoJugador(java.lang.Integer arg0, java.lang.Integer arg1) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.eliminarJuegoDelCarritoJugador(arg0, arg1);
  }
  
  public void cargarBilleteraJugador(java.lang.Integer arg0, java.lang.Float arg1) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.cargarBilleteraJugador(arg0, arg1);
  }
  
  public web_service.DataUsuario buscarUsuarioNick(java.lang.String arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.buscarUsuarioNick(arg0);
  }
  
  public float darVentasTotal() throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.darVentasTotal();
  }
  
  public web_service.DataCategoria[] listarCategorias() throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.listarCategorias();
  }
  
  public float darVentasCreador(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.darVentasCreador(arg0);
  }
  
  public void crearOferta(java.lang.String arg0, java.util.Calendar arg1, java.util.Calendar arg2, float arg3) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.crearOferta(arg0, arg1, arg2, arg3);
  }
  
  public java.lang.Float darSaldoJugador(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.darSaldoJugador(arg0);
  }
  
  public web_service.DataJuego[] juegoMasVendidos() throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.juegoMasVendidos();
  }
  
  public void valorarJuego(java.lang.Integer arg0, java.lang.Integer arg1, java.lang.Integer arg2) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.valorarJuego(arg0, arg1, arg2);
  }
  
  public void agregarCategoria(java.lang.String arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.agregarCategoria(arg0);
  }
  
  public void registrarAdmin(web_service.DataAdmin arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.registrarAdmin(arg0);
  }
  
  public void realizarCheckout(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.realizarCheckout(arg0);
  }
  
  public void comentarJuego(java.lang.String arg0, java.lang.Integer arg1, java.lang.Integer arg2) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.comentarJuego(arg0, arg1, arg2);
  }
  
  public java.lang.Integer darCantVentasCreador(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.darCantVentasCreador(arg0);
  }
  
  public void reportarComentario(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.reportarComentario(arg0);
  }
  
  public web_service.DataOferta[] listarOfertasPendientes() throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.listarOfertasPendientes();
  }
  
  public web_service.DataComentario[] darUltimosComentariosJuego(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.darUltimosComentariosJuego(arg0);
  }
  
  public web_service.DataCreador darDatosCreadorJuego(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.darDatosCreadorJuego(arg0);
  }
  
  public void responderComentario(java.lang.Integer arg0, java.lang.String arg1, java.lang.Integer arg2) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.responderComentario(arg0, arg1, arg2);
  }
  
  public web_service.DataJuego[] darBibliotecaJugador(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.darBibliotecaJugador(arg0);
  }
  
  public java.lang.Integer darCantVentasJuego(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.darCantVentasJuego(arg0);
  }
  
  public web_service.DataJuego[] juegoMasVendidosCreador(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.juegoMasVendidosCreador(arg0);
  }
  
  public void quitarJuegoAOferta(java.lang.Integer arg0, int[] arg1) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.quitarJuegoAOferta(arg0, arg1);
  }
  
  public void agregarJuegoAOferta(java.lang.Integer arg0, int[] arg1) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.agregarJuegoAOferta(arg0, arg1);
  }
  
  public web_service.DataComentario[] darComentariosReportados() throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.darComentariosReportados();
  }
  
  public web_service.DataJuego[] buscarJuegos(java.lang.String arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.buscarJuegos(arg0);
  }
  
  public void publicarPost(web_service.TipoPost arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Integer arg3) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.publicarPost(arg0, arg1, arg2, arg3);
  }
  
  public web_service.DataOferta[] listarOfertas() throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.listarOfertas();
  }
  
  public web_service.DataPagina listarPost(java.lang.Integer arg0, java.lang.Integer arg1) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.listarPost(arg0, arg1);
  }
  
  public void bloquearJuego(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.bloquearJuego(arg0);
  }
  
  public void reportarJuego(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.reportarJuego(arg0);
  }
  
  public void bloquearComentario(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.bloquearComentario(arg0);
  }
  
  public web_service.DataJuego[] darJuegosReportados() throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.darJuegosReportados();
  }
  
  public void desbloquearJuego(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.desbloquearJuego(arg0);
  }
  
  public void solicitarDesbloquearJuego(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.solicitarDesbloquearJuego(arg0);
  }
  
  public web_service.DataJuego[] darJuegosBloqueados(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.darJuegosBloqueados(arg0);
  }
  
  public web_service.DataJuego[] darJuegosSolicitados() throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.darJuegosSolicitados();
  }
  
  
}