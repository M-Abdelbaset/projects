package test.com;

public class Name2Proxy implements test.com.Name2 {
  private String _endpoint = null;
  private test.com.Name2 name2 = null;
  
  public Name2Proxy() {
    _initName2Proxy();
  }
  
  public Name2Proxy(String endpoint) {
    _endpoint = endpoint;
    _initName2Proxy();
  }
  
  private void _initName2Proxy() {
    try {
      name2 = (new com.home.service.MartServiceLocator()).getmartPort();
      if (name2 != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)name2)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)name2)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (name2 != null)
      ((javax.xml.rpc.Stub)name2)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public test.com.Name2 getName2() {
    if (name2 == null)
      _initName2Proxy();
    return name2;
  }
  
  public test.com.Type[] findCategories() throws java.rmi.RemoteException{
    if (name2 == null)
      _initName2Proxy();
    return name2.findCategories();
  }
  
  public test.com.Type addCategories(java.lang.String cat, test.com.Type data) throws java.rmi.RemoteException, test.com.CustomException{
    if (name2 == null)
      _initName2Proxy();
    return name2.addCategories(cat, data);
  }
  
  
}