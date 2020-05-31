/**
 * Name2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package test.com;

public interface Name2 extends java.rmi.Remote {
    public test.com.Type[] findCategories() throws java.rmi.RemoteException;
    public test.com.Type addCategories(java.lang.String cat, test.com.Type data) throws java.rmi.RemoteException, test.com.CustomException;
}
