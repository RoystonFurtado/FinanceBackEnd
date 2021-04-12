package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.GenericDao;
import com.lti.entity.EMICard;

@Component
public class EmiCardService implements Service {

	@Autowired
	GenericDao dao;

	@Override
	public void add(Object o) {
		dao.save(o);
	}

	@Override
	public Object fetchByPk(Object o) {
		return (EMICard)dao.fetchById(EMICard.class,o);
	}
	
	
}
