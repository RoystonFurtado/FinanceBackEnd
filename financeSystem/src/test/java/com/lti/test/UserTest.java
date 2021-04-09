package com.lti.test;

import java.time.LocalDate;

import org.junit.Test;

import com.lti.entity.CardInfo;
import com.lti.entity.EMICard;
import com.lti.entity.User;
import com.lti.service.EmiCardService;
import com.lti.service.Service;
import com.lti.service.UserService;

public class UserTest {
	Service us=new UserService();
	Service ecs=new EmiCardService();
	
	@Test
	public void addUser() {
		User u=new User();
		u.setUserName("Bruno Fernandes");
		u.setEmailId("bruno@hotmail.com");
		u.setAddress("Manchester");
		u.setDob(LocalDate.of(1990,6,2));
		u.setPassword("bruno123");
		u.setMobileNo(9234633589L);
		EMICard emiCard=(EMICard)ecs.fetchByPk("Titanium");
		u.setProfileStatus("Inactive");//Default Value
		u.setEmiCard(emiCard);
		//Document Id is inserted through a before insert trigger and sequence on the database
		us.add(u);
		
	}
	
	@Test
	public void activateUser() {
		User u=(User)us.fetchByPk(391);
		CardInfo c=new CardInfo();
		c.setCardBalance(u.getEmiCard().getCardLimit());
		c.setCardCreditUsed(0);
		//3 Years(Validity Period fetched from emi_card) from current date is expiry date
		c.setCardExpiryDate(LocalDate.now().plusYears(u.getEmiCard().getValidityPeriod()));
		u.setCardInfo(c);
		us.add(u);
	}
	
}
