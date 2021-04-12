package com.lti.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lti.dao.UserCardDao;
import com.lti.entity.CardInfo;
import com.lti.entity.User;

public class UserCardTest {
	
	@Autowired
	UserCardDao dao;
	
	@Test
	public void fetchActiveAllGoldUsers() {
		List<User> list = dao.fetchActiveAllGoldUsers();
		// System.out.println(list); //for checking null
		for(User user : list)
			System.out.println(user.getUserId() + "," + user.getUserName());
	}

	@Test
	public void fetchByUserName() {
		List<User> list = dao.fetchByUserName("so");
		for(User u : list)
			System.out.println(u.getUserId() + "," + u.getUserName()+ "," + u.getEmailId());	
	}
	
	@Test
	public void fetchValidCard() {
		List<User> list = dao.fetchValidCard();
		for(User ci : list)
			System.out.println(ci.getUserId() + "," + ci.getUserName()+ "," + ci.getCardInfo().getCardExpiryDate());
	}
}