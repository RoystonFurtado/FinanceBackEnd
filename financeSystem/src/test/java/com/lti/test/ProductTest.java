package com.lti.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.GenericDao;
import com.lti.entity.Product;
import com.lti.entity.User;
import com.lti.service.ProductService;
import com.lti.service.Service;
import com.lti.service.UserService;

public class ProductTest {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("app-config.xml");
	//Service ps=(Service)ctx.getBean("productService");
	
	@Autowired
	@Qualifier("productService")
	Service ps;
	
	@Test
	public void addProduct() {
		Product p=new Product();
		p.setProductName("Realme 6 pro plus");
		p.setProductPrice(25000);
		p.setProductDescription("Oppo is the parent company of RealMe");
		p.setProductCategory("Laptop");
		ps.add(p);
	}	
	
	@Test
	public void fetchByProductId() {
		Product p=(Product)ps.fetchByPk(222);
		System.out.println(p.getProductId()+p.getProductName()+p.getProductPrice());
		
	}

}
