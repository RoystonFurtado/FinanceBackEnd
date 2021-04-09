package com.lti.service;

import com.lti.dao.GenericDao;
import com.lti.entity.EMICard;

public class EmiCardService implements Service {

	GenericDao dao=new GenericDao();

	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object fetchByPk(Object o) {
		// TODO Auto-generated method stub
		return (EMICard)dao.fetchById(EMICard.class,o);
	}
	
	
}
