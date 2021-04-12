package com.lti.test;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;

import com.lti.entity.CardInfo;
import com.lti.entity.Order;
import com.lti.entity.Product;
import com.lti.entity.User;
import com.lti.service.CardInfoService;
import com.lti.service.OrderService;
import com.lti.service.ProductService;
import com.lti.service.Service;
import com.lti.service.UserService;

public class OrderTest {
	
	Service us=new UserService();
	Service ps=new ProductService();
	OrderService os = new OrderService();
	Service cis=new CardInfoService();
	
	@Test
	public void addOrder() {
		Order order=new Order();
		User user=(User)us.fetchByPk(10003);
		Product product=(Product)ps.fetchByPk(420);
		order.setUser(user);
		order.setProduct(product);
		order.setAmountPaid(0);//Default Value
		order.setAmountBalance(product.getProductPrice());
		order.setTenurePeriod(3);
		order.setPurchaseDate(LocalDateTime.now());
		order.setEMIMonthsPaid(0);//Default Value
		order.setOrderStatus("Active");//Default Value
		order.setMonthlyEMIAmount(product.getProductPrice()/3);
		os.addNewOrder(order);
		
		CardInfo c=user.getCardInfo();
		c.setCardCreditUsed(c.getCardCreditUsed()+product.getProductPrice());
		c.setCardBalance(c.getCardBalance()-product.getProductPrice());
		cis.add(c);	
	}
	
	@Test
	public void fetchAllActiveOrders() {
		List<Order> allActiveOrders=os.fetchAllActiveOrders();
		for(Order order:allActiveOrders) {
			System.out.println("------Order Id:"+order.getOrderId()+"------");
			System.out.println("User Id:"+order.getUser().getUserId());
			System.out.println("Product Id:"+order.getProduct().getProductId());
			System.out.println("Amount Paid:"+order.getAmountPaid());
			System.out.println("Tenure Period:"+order.getTenurePeriod());
			System.out.println("Purchase Date and Time:"+order.getPurchaseDate());
			System.out.println("Amount Balance:"+order.getEMIMonthsPaid());
			System.out.println("EMI Months Paid:"+order.getEMIMonthsPaid());
			System.out.println("Order Status:"+order.getOrderStatus());
			System.out.println("Monthly EMI Amount:"+order.getMonthlyEMIAmount());
			System.out.println();
		}
	}
	
	@Test
	public void fetchOrdersByUser() {
		List<Order> userOrders=os.fetchOrdersByUser(10003);
		System.out.println("------"+userOrders.get(0).getUser().getUserName()+"'s Orders------\n");
		for(Order order:userOrders) {
			System.out.println("------Order Id:"+order.getOrderId()+"------");
			System.out.println("Product Id:"+order.getProduct().getProductId());
			System.out.println("Amount Paid:"+order.getAmountPaid());
			System.out.println("Tenure Period:"+order.getTenurePeriod());
			System.out.println("Purchase Date and Time:"+order.getPurchaseDate());
			System.out.println("Amount Balance:"+order.getEMIMonthsPaid());
			System.out.println("EMI Months Paid:"+order.getEMIMonthsPaid());
			System.out.println("Order Status:"+order.getOrderStatus());
			System.out.println("Monthly EMI Amount:"+order.getMonthlyEMIAmount());
			System.out.println();
		}
	}

}
