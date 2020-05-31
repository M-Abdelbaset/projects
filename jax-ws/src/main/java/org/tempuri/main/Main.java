package org.tempuri.main;

import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;

import com.home.service.MartService;
import com.home.service.MartServiceLocator;
import test.com.Type;

public class Main {

	public static void main(String[] args) throws RemoteException, ServiceException {
		MartService locator = new MartServiceLocator();
				
		Type[] types = locator.getmartPort().findCategories();
		for(Type t : types) {
			System.out.println(t.get_name() + " : " + t.getAge());
		}
	}
}
