package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.lti.dao.UserDao;
import com.lti.entity.User;

@Component("userService")
public class UserService implements Service{

	ApplicationContext ctx=new ClassPathXmlApplicationContext("app-config.xml");
	//GenericDao dao=(GenericDao)ctx.getBean("genericDao");
	
	@Autowired
	UserDao dao;

	@Override
	@Transactional
	public void add(Object o) {
		dao.save(o);
	}

	@Override
	public Object fetchByPk(Object o) {
		return (User)dao.fetchById(User.class,o);
	}
	
	public List<User> fetchAllActiveGoldUsers() {
		return dao.fetchAllActiveGoldUsers();
	}
	
	public List<User> fetchUsersByName(String username) {
		return dao.fetchUsersByName(username);
	}
	
	public List<User> fetchValidCards() {
		return dao.fetchValidCards();
	}
	
	
}
