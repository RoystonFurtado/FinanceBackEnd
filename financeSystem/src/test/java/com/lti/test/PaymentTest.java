package com.lti.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.GenericDao;
import com.lti.entity.CardInfo;
import com.lti.entity.Installment;
import com.lti.entity.Order;
import com.lti.entity.Payment;
import com.lti.entity.User;
import com.lti.service.CardInfoService;
import com.lti.service.InstallmentService;
import com.lti.service.OrderService;
import com.lti.service.Service;
import com.lti.service.UserService;

public class PaymentTest {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("app-config.xml");
	
//	InstallmentService is=(InstallmentService)ctx.getBean("installmentService");
//	Service os=(Service)ctx.getBean("orderService");
//	Service cis=(Service)ctx.getBean("cardInfoService1");
	
	@Autowired
	InstallmentService is;
	
	@Autowired
	@Qualifier("orderService")
	Service os;
	
	@Autowired
	@Qualifier("cardInfoService")
	Service cis;
	
	@Test
	public void addPaymentForInstallment() {
		Payment p=new Payment();
		p.setPaymentDate(LocalDateTime.now());
		Order o=(Order)os.fetchByPk(100004);
		Installment activeInstallment=is.fetchActiveInstallment(o.getOrderId());
		p.setPaymentAmount(o.getMonthlyEMIAmount());
		//Days between payment date and active installment's due date
		//If positive value payment is overdue and if negative value or 0 payment is done on time
		long extraDays=ChronoUnit.DAYS.between(activeInstallment.getDueDate(),LocalDate.now());
		double fine=(extraDays>0)?(extraDays*20):0;
		p.setFineAmount(fine);
		activeInstallment.setPayment(p);
		activeInstallment.setInstallmentStatus("Completed");
		is.add(activeInstallment);
		
		//Check if entering a new installment phase
		Installment nextInstallment;
		if(extraDays>0) {
			nextInstallment=is.fetchNextInstallment(activeInstallment);
			nextInstallment.setInstallmentStatus("Active");
			is.add(nextInstallment);
		}
		
		//Updating order data
		o.setAmountBalance(o.getAmountBalance()-p.getPaymentAmount());
		o.setAmountPaid(o.getAmountPaid()+p.getPaymentAmount());
		o.setEMIMonthsPaid(o.getEMIMonthsPaid()+1);
		os.add(o);
		
		//Updating EMI Card balance of the user
		User u=o.getUser();
		CardInfo c=u.getCardInfo();
		c.setCardBalance(c.getCardBalance()+o.getAmountPaid()-p.getFineAmount());
		c.setCardCreditUsed(c.getCardCreditUsed()-o.getAmountPaid()+p.getFineAmount());
		cis.add(c);	
	}
	
}
