package com.lti.service;

import org.springframework.stereotype.Component;

@Component
public interface Service {
	
	public void add(Object o);
	public Object fetchByPk(Object o);
	
}
