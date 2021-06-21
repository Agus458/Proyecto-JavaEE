/**
 * SteamIndie.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package web_service;

public interface SteamIndie extends java.rmi.Remote {
    public web_service.DataUsuario buscarUsuarioEmail(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.Boolean nickEnUso(java.lang.String arg0) throws java.rmi.RemoteException;
    public void registrarJugador(web_service.DataJugador arg0) throws java.rmi.RemoteException;
    public void comentarJuego(java.lang.String arg0, java.lang.Integer arg1, java.lang.Integer arg2) throws java.rmi.RemoteException;
    public void agregarCategoria(java.lang.String arg0) throws java.rmi.RemoteException;
    public void registrarAdmin(web_service.DataAdmin arg0) throws java.rmi.RemoteException;
    public float darVentasCreador(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public void registrarCreador(web_service.DataCreador arg0) throws java.rmi.RemoteException;
    public float darVentasTotal() throws java.rmi.RemoteException;
    public java.lang.Float darSaldoJugador(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public void publicarJuego(web_service.DataJuego arg0, java.lang.Integer arg1) throws java.rmi.RemoteException;
    public void publicarPost(web_service.TipoPost arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Integer arg3) throws java.rmi.RemoteException;
    public web_service.DataJuego buscarJuegoId(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public web_service.DataJuego[] buscarJuegos(java.lang.String arg0) throws java.rmi.RemoteException;
    public web_service.DataOferta[] listarOfertas() throws java.rmi.RemoteException;
    public void crearOferta(java.lang.String arg0, java.util.Calendar arg1, java.util.Calendar arg2, float arg3) throws java.rmi.RemoteException;
    public void bloquearJuego(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public web_service.DataPagina listarPost(java.lang.Integer arg0, java.lang.Integer arg1) throws java.rmi.RemoteException;
    public web_service.DataJuego[] juegoMasVendidos() throws java.rmi.RemoteException;
    public web_service.DataUsuario[] listarUsuarios() throws java.rmi.RemoteException;
    public web_service.DataJuego[] listarJuegos() throws java.rmi.RemoteException;
    public web_service.DataUsuario buscarUsuarioId(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public java.lang.Boolean nombreJuegoEnUso(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.Boolean emailEnUso(java.lang.String arg0) throws java.rmi.RemoteException;
    public void valorarJuego(java.lang.Integer arg0, java.lang.Integer arg1, java.lang.Integer arg2) throws java.rmi.RemoteException;
    public void desbloquearJuego(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public void reportarJuego(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public web_service.DataJugador[] listarJugadores() throws java.rmi.RemoteException;
    public void realizarCheckout(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public web_service.DataCategoria[] listarCategorias() throws java.rmi.RemoteException;
    public web_service.DataJuego[] juegoMasVendidosCreador(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public web_service.DataJuego[] darJuegosReportados() throws java.rmi.RemoteException;
    public web_service.DataCarrito darDatosCarritoJugador(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public web_service.DataUsuario buscarUsuarioNick(java.lang.String arg0) throws java.rmi.RemoteException;
    public web_service.DataJuego buscarJuegoNombre(java.lang.String arg0) throws java.rmi.RemoteException;
    public void agregarJuegoAlCarritoJugador(java.lang.Integer arg0, java.lang.Integer arg1) throws java.rmi.RemoteException;
    public void eliminarJuegoDelCarritoJugador(java.lang.Integer arg0, java.lang.Integer arg1) throws java.rmi.RemoteException;
    public web_service.DataComentario[] darUltimosComentariosJuego(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public java.lang.Integer darCantVentasJuego(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public void reportarComentario(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public web_service.DataOferta[] listarOfertasPendientes() throws java.rmi.RemoteException;
    public java.lang.Integer darCantVentasCreador(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public void solicitarDesbloquearJuego(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public void quitarJuegoAOferta(java.lang.Integer arg0, int[] arg1) throws java.rmi.RemoteException;
    public web_service.DataJuego[] darJuegosSolicitados() throws java.rmi.RemoteException;
    public web_service.DataJuego[] darJuegosEnOferaCreador(java.lang.Integer arg0, java.lang.Integer arg1) throws java.rmi.RemoteException;
    public web_service.DataJuego[] darJuegosNoEnOferaCreador(java.lang.Integer arg0, java.lang.Integer arg1) throws java.rmi.RemoteException;
    public web_service.DataJuego[] darBibliotecaJugador(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public void cargarBilleteraJugador(java.lang.Integer arg0, java.lang.Float arg1) throws java.rmi.RemoteException;
    public void agregarJuegoAOferta(java.lang.Integer arg0, int[] arg1) throws java.rmi.RemoteException;
    public web_service.DataCreador darDatosCreadorJuego(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public web_service.DataComentario[] darComentariosReportados() throws java.rmi.RemoteException;
    public void bloquearComentario(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public void responderComentario(java.lang.Integer arg0, java.lang.String arg1, java.lang.Integer arg2) throws java.rmi.RemoteException;
    public web_service.DataJuego[] darJuegosBloqueados(java.lang.Integer arg0) throws java.rmi.RemoteException;
}
