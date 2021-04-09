package com.lti.service;

import java.util.List;

import com.lti.dao.GenericDao;
import com.lti.entity.User;

public class UserService implements Service{

	GenericDao dao=new GenericDao();

	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		dao.save(o);
		
	}

	@Override
	public Object fetchByPk(Object o) {
		// TODO Auto-generated method stub
		return (User)dao.fetchById(User.class,o);
	}
	
	
	
}
