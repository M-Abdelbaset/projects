package com.home.service;

import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.home.model.CustomType;

@SOAPBinding(style = Style.DOCUMENT)
@WebService(targetNamespace = "com.test", name = "name2")
public interface IProductCategory {

	@WebMethod(exclude = false, action = "find_categories", operationName = "findCategories")
	@WebResult(name = "response")
	Set<CustomType> getCategories();

	@WebMethod
	public CustomType addCategories(@WebParam(partName = "cat", name = "cat", targetNamespace = "hello") String category,
			@WebParam(name = "data") CustomType customType) throws CustomException;

}