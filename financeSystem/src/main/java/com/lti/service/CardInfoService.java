package com.lti.service;

import com.lti.dao.GenericDao;
import com.lti.entity.CardInfo;

public class CardInfoService implements Service{

	GenericDao dao=new GenericDao();
	
	@Override
	public void add(Object o) {
		dao.save(o);
	}

	@Override
	public Object fetchByPk(Object o) {
		return (CardInfo)dao.fetchById(CardInfo.class,o);
	}

}
