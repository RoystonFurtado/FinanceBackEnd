package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.GenericDao;
import com.lti.entity.User;

@Component
public class UserService implements Service{

	@Autowired
	GenericDao dao;

	@Override
	public void add(Object o) {
		dao.save(o);
	}

	@Override
	public Object fetchByPk(Object o) {
		return (User)dao.fetchById(User.class,o);
	}
	
	
	
}
