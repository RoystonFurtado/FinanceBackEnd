package com.lti.test;

import java.time.LocalDateTime;

import org.junit.Test;

import com.lti.entity.Installment;
import com.lti.entity.Order;
import com.lti.entity.Payment;
import com.lti.service.InstallmentService;
import com.lti.service.OrderService;
import com.lti.service.Service;

public class PaymentTest {
	InstallmentService is=new InstallmentService();
	Service os=new OrderService();
	
	@Test
	public void addPaymentForInstallment() {
		Payment p=new Payment();
		p.setPaymentDate(LocalDateTime.now());
		Order o=(Order)os.fetchByPk(100000);
		Installment i=is.fetchActiveInstallment(o.getOrderId());
		p.setPaymentAmount(o.getMonthlyEMIAmount());
		p.setFineAmount(0);
		i.setPayment(p);
		is.add(i);
	}
}
