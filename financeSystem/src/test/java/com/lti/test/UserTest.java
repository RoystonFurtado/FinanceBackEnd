package com.lti.test;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.GenericDao;
import com.lti.entity.CardInfo;
import com.lti.entity.EMICard;
import com.lti.entity.User;
import com.lti.service.EmiCardService;
import com.lti.service.Service;
import com.lti.service.UserService;

public class UserTest {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("app-config.xml");
	
//	Service us=(Service)ctx.getBean("userService");
//	Service ecs=(Service)ctx.getBean("emiCardService");
	
	@Autowired
	UserService us;
	
	@Autowired
	@Qualifier("emiCardService")
	Service ecs;
	
	@Test
	public void addUser() {
		User u=new User();
		u.setUserName("Vivek");
		u.setEmailId("vivek@yahoo.com");
		u.setAddress("Mumbai");
		u.setDob(LocalDate.of(1987,6,21));
		u.setPassword("nopass123");
		u.setMobileNo(919524567123L);
		EMICard emiCard=(EMICard)ecs.fetchByPk("Titanium");
		u.setProfileStatus("Inactive");//Default Value
		u.setEmiCard(emiCard);
		//Document Id is inserted through a before insert trigger and sequence on the database
		//hello
		us.add(u);
	}
	
	@Test
	public void activateUser() {		
		User u=(User)us.fetchByPk(10003);
		CardInfo c=new CardInfo();
		c.setCardBalance(u.getEmiCard().getCardLimit()-u.getEmiCard().getJoiningFee());
		c.setCardCreditUsed(u.getEmiCard().getJoiningFee());
		//3 Years(Validity Period fetched from emi_card) from current date is expiry date
		c.setCardExpiryDate(LocalDate.now().plusYears(u.getEmiCard().getValidityPeriod()));
		u.setProfileStatus("Active");
		u.setCardInfo(c);
		us.add(u);
	}
	
	@Test
	public void fetchActiveAllGoldUsers() {
		List<User> list = us.fetchAllActiveGoldUsers();
		// System.out.println(list); //for checking null
		for(User user : list)
			System.out.println(user.getUserId() + "," + user.getUserName());
	}

	@Test
	public void fetchByUserName() {
		List<User> list = us.fetchUsersByName("so");
		for(User u : list)
			System.out.println(u.getUserId() + "," + u.getUserName()+ "," + u.getEmailId());	
	}
	
	@Test
	public void fetchValidCards() {
		List<User> list = us.fetchValidCards();
		for(User ci : list)
			System.out.println(ci.getUserId() + "," + ci.getUserName()+ "," + ci.getCardInfo().getCardExpiryDate());
	}
	
}
