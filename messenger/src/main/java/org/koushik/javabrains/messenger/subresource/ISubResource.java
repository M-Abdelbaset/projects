package org.koushik.javabrains.messenger.subresource;

public interface ISubResource {
	public String get(int id) ;
	public String getWithParam(int mainId, int subId, int count);
}
