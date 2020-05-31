package com.home.scopes;

import java.util.UUID;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
//@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS) // this annotation must define both scope and proxy to work
public class SessionScopeBean {
	
	private final UUID uuid;
	
	public SessionScopeBean() {
		this.uuid = UUID.randomUUID();
	}
	
	@Override
	public String toString() {
		return "SessionScopeBean [uuid=" + uuid + "]";
	}
}
