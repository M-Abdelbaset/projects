package com.home.scopes;

import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope // this annotation is proxied
public class RequestScopeBean {
	
	private final UUID uuid;
	
	public RequestScopeBean() {
		this.uuid = UUID.randomUUID();
	}
	
	@Override
	public String toString() {
		return "RequestScopeBean [uuid=" + uuid + "]";
	}
}
