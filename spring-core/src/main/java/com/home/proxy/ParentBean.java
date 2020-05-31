package com.home.proxy;

import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Component
@Setter @Getter
public class ParentBean {

	@Autowired
	private SingletonBean singletonBean;
	
	@Autowired
	private PrototypeBean prototypeBean;
	
	@Autowired
	private ObjectFactory<PrototypeBean> pFactory;
	
	@Inject
	private Provider<PrototypeBean> provider;
	
	@Autowired
	private ProxiedSingletonBean proxiedSingletonBean;
	
	@Autowired
	private ProxiedPrototypeBean proxiedPrototypeBean;
}
