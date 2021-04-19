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
  
  public web_service.DataUsuario buscarUsuarioNick(java.lang.String arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.buscarUsuarioNick(arg0);
  }
  
  public web_service.DataUsuario[] listarUsuarios() throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.listarUsuarios();
  }
  
  public void registrarJugador(web_service.DataJugador arg0) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    steamIndie.registrarJugador(arg0);
  }
  
  public java.lang.Boolean validarRegistro(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (steamIndie == null)
      _initSteamIndieProxy();
    return steamIndie.validarRegistro(arg0, arg1);
  }
  
  
}