/**
 * SteamIndie.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package web_service;

public interface SteamIndie extends java.rmi.Remote {
    public web_service.DataUsuario buscarUsuarioEmail(java.lang.String arg0) throws java.rmi.RemoteException;
    public web_service.DataUsuario buscarUsuarioNick(java.lang.String arg0) throws java.rmi.RemoteException;
    public web_service.DataUsuario[] listarUsuarios() throws java.rmi.RemoteException;
    public void registrarJugador(web_service.DataJugador arg0) throws java.rmi.RemoteException;
    public java.lang.Boolean validarRegistro(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
}
