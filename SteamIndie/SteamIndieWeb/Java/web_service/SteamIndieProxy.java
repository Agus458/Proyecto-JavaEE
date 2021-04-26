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
  
  public web_service.DataUsuario buscarUsuarioEmail(java.lang.String arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.buscarUsuarioEmail(arg0);
  }
  
  public void registrarJugador(web_service.DataJugador arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.registrarJugador(arg0);
  }
  
  public web_service.DataCategoria[] listarCategorias() throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.listarCategorias();
  }
  
  public void publicarJuego(web_service.DataJuego arg0, java.lang.Integer arg1) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.publicarJuego(arg0, arg1);
  }
  
  public web_service.DataJuego[] listarJuegos() throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.listarJuegos();
  }
  
  public java.lang.Boolean nombreJuegoEnUso(java.lang.String arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.nombreJuegoEnUso(arg0);
  }
  
  public void registrarCreador(web_service.DataCreador arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.registrarCreador(arg0);
  }
  
  public java.lang.Boolean nickEnUso(java.lang.String arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.nickEnUso(arg0);
  }
  
  public web_service.DataJuego buscarJuegoId(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.buscarJuegoId(arg0);
  }
  
  public java.lang.Float darSaldoJugador(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.darSaldoJugador(arg0);
  }
  
  public web_service.DataUsuario buscarUsuarioId(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.buscarUsuarioId(arg0);
  }
  
  public java.lang.Boolean emailEnUso(java.lang.String arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.emailEnUso(arg0);
  }
  
  public void realizarCheckout(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.realizarCheckout(arg0);
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
  
  public void eliminarJuegoDelCarritoJugador(java.lang.Integer arg0, java.lang.Integer arg1) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.eliminarJuegoDelCarritoJugador(arg0, arg1);
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
  
  
}