/**
 * SteamIndieImpServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package web_service;

public class SteamIndieImpServiceLocator extends org.apache.axis.client.Service implements web_service.SteamIndieImpService {

    public SteamIndieImpServiceLocator() {
    }


    public SteamIndieImpServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SteamIndieImpServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SteamIndieImpPort
    private java.lang.String SteamIndieImpPort_address = "http://localhost:1515/SteamIndieWS";

    public java.lang.String getSteamIndieImpPortAddress() {
        return SteamIndieImpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SteamIndieImpPortWSDDServiceName = "SteamIndieImpPort";

    public java.lang.String getSteamIndieImpPortWSDDServiceName() {
        return SteamIndieImpPortWSDDServiceName;
    }

    public void setSteamIndieImpPortWSDDServiceName(java.lang.String name) {
        SteamIndieImpPortWSDDServiceName = name;
    }

    public web_service.SteamIndie getSteamIndieImpPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SteamIndieImpPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSteamIndieImpPort(endpoint);
    }

    public web_service.SteamIndie getSteamIndieImpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            web_service.SteamIndieImpPortBindingStub _stub = new web_service.SteamIndieImpPortBindingStub(portAddress, this);
            _stub.setPortName(getSteamIndieImpPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSteamIndieImpPortEndpointAddress(java.lang.String address) {
        SteamIndieImpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (web_service.SteamIndie.class.isAssignableFrom(serviceEndpointInterface)) {
                web_service.SteamIndieImpPortBindingStub _stub = new web_service.SteamIndieImpPortBindingStub(new java.net.URL(SteamIndieImpPort_address), this);
                _stub.setPortName(getSteamIndieImpPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SteamIndieImpPort".equals(inputPortName)) {
            return getSteamIndieImpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://web_service/", "SteamIndieImpService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://web_service/", "SteamIndieImpPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SteamIndieImpPort".equals(portName)) {
            setSteamIndieImpPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
