package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.GenericDao;
import com.lti.entity.CardInfo;

@Component
public class CardInfoService implements Service{

	@Autowired
	GenericDao dao;
	
	@Override
	public void add(Object o) {
		dao.save(o);
	}

	@Override
	public Object fetchByPk(Object o) {
		return (CardInfo)dao.fetchById(CardInfo.class,o);
	}

}
