package com.lti.test;

import java.time.LocalDateTime;

import org.junit.Test;

import com.lti.entity.Order;
import com.lti.entity.Product;
import com.lti.entity.User;
import com.lti.service.EmiCardService;
import com.lti.service.OrderService;
import com.lti.service.ProductService;
import com.lti.service.Service;
import com.lti.service.UserService;

public class OrderTest {
	Service us=new UserService();
	Service ps=new ProductService();
	Service os = new OrderService();
	@Test
	public void addOrder() {
		Order order = new Order();
		User user = (User) us.fetchByPk(10002);
		Product product = (Product) ps.fetchByPk(201);
		order.setUser(user);
		order.setProduct(product);
		order.setAmountPaid(0);
		order.setAmountBalance(product.getProductPrice());
		order.setTenurePeriod(3);
		order.setPurchaseDate(LocalDateTime.now());
		order.setEMIMonthsPaid(0);
		order.setOrderStatus("Active");
		double emi = product.getProductPrice()/3; 
		order.setMonthlyEMIAmount(emi);
		os.add(order);
	}

}
