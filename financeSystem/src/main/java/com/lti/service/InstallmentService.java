package com.lti.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.lti.dao.GenericDao;
import com.lti.dao.InstallmentDao;
import com.lti.entity.Installment;
import com.lti.entity.Order;

@Component("installmentService")
public class InstallmentService implements Service {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("app-config.xml");
	//InstallmentDao dao=(InstallmentDao)ctx.getBean("installmentDao");
	
	@Autowired
	@Qualifier("installmentDao")
	InstallmentDao dao;
	
	@Override
	@Transactional
	public void add(Object o) {
		dao.save(o);
	}

	@Override
	public Object fetchByPk(Object o) {
		return (Installment)dao.fetchById(Installment.class,o);
	}
	
	@Transactional
	public void addInstallments(Order order) {	
		Installment i;
		LocalDate installmentDate;
		LocalDate currentDate = LocalDate.now();
		LocalDate currentDatePlus1Month = currentDate.plusMonths(1);
		LocalDate currentDatePlus2Month = currentDate.plusMonths(2);
		
		//Calculation of first installment due date
		//If purchase date is in between 1st to 20th of the month then 1st installment due date will be 5th of next month else 5th of next to next month
		if(currentDate.getDayOfMonth()<=20) {
			installmentDate = LocalDate.of(currentDatePlus1Month.getYear(), currentDatePlus1Month.getMonth(), 5);
		}
		else {
			installmentDate = LocalDate.of(currentDatePlus2Month.getYear(), currentDatePlus2Month.getMonth(), 5);
		}
		for(int t = 0;t<order.getTenurePeriod();t++) {
			i = new Installment();
			i.setInstallmentNo(t+1);
			i.setDueDate(installmentDate.plusMonths(t));
			//Initially 1st installment is active
			if(t==0) 
				i.setInstallmentStatus("Active");
			else 
				i.setInstallmentStatus("Inactive");
			i.setOrder(order);
			dao.save(i);
		}		
	}
	
	public Installment fetchActiveInstallment(int id) {
		return dao.fetchActiveInstallment(id);
	}
	
	public Installment fetchNextInstallment(Installment currentInstallment) {
		return dao.fetchNextInstallment(currentInstallment);
	}

}
