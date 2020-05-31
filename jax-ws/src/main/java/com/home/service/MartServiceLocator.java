/**
 * MartServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.home.service;

public class MartServiceLocator extends org.apache.axis.client.Service implements com.home.service.MartService {

    public MartServiceLocator() {
    }


    public MartServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MartServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for martPort
    private java.lang.String martPort_address = "http://localhost:8080/jaxws-server/martService";

    public java.lang.String getmartPortAddress() {
        return martPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String martPortWSDDServiceName = "martPort";

    public java.lang.String getmartPortWSDDServiceName() {
        return martPortWSDDServiceName;
    }

    public void setmartPortWSDDServiceName(java.lang.String name) {
        martPortWSDDServiceName = name;
    }

    public test.com.Name2 getmartPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(martPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getmartPort(endpoint);
    }

    public test.com.Name2 getmartPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.home.service.MartServiceSoapBindingStub _stub = new com.home.service.MartServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getmartPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setmartPortEndpointAddress(java.lang.String address) {
        martPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (test.com.Name2.class.isAssignableFrom(serviceEndpointInterface)) {
                com.home.service.MartServiceSoapBindingStub _stub = new com.home.service.MartServiceSoapBindingStub(new java.net.URL(martPort_address), this);
                _stub.setPortName(getmartPortWSDDServiceName());
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
        if ("martPort".equals(inputPortName)) {
            return getmartPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.home.com/", "martService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.home.com/", "martPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("martPort".equals(portName)) {
            setmartPortEndpointAddress(address);
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
