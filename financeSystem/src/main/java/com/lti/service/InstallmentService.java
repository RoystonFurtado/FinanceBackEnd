package com.lti.service;

import java.time.LocalDate;

import com.lti.dao.GenericDao;
import com.lti.entity.Installment;
import com.lti.entity.Order;

public class InstallmentService implements Service {

	GenericDao dao = new GenericDao();
	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object fetchByPk(Object o) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void addInstallments(Order order) {
		Installment i;
		LocalDate installmentDate;
		LocalDate currentDate = LocalDate.now();
		LocalDate date1 = currentDate.plusMonths(1);
		LocalDate date2 = currentDate.plusMonths(2);
		if(currentDate.getDayOfMonth()<=20) {
			installmentDate = LocalDate.of(date1.getYear(), date1.getMonth(), 5);
		}
		else {
			installmentDate = LocalDate.of(date2.getYear(), date2.getMonth(), 5);
		}
		for(int t = 0;t<order.getTenurePeriod();t++) {
			i = new Installment();
			i.setInstallmentNo(t+1);
			i.setDueDate(installmentDate.plusMonths(t));
			if(t==0) 
				i.setInstallmentStatus("Active");
			else 
				i.setInstallmentStatus("Inactive");
			i.setOrder(order);
			dao.save(i);
		}
		
		
		
	}
	
	

}
