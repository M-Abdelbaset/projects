package com.home.scopes;

import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope // this annotation is proxied
public class ApplicationScopeBean {
	
	private final UUID uuid;
	
	public ApplicationScopeBean() {
		this.uuid = UUID.randomUUID();
	}
	
	@Override
	public String toString() {
		return "ApplicationScopeBean [uuid=" + uuid + "]";
	}
}
