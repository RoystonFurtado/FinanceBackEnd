package com.lti.test;

import java.util.List;

import org.junit.Test;

import com.lti.entity.Product;
import com.lti.entity.User;
import com.lti.service.ProductService;
import com.lti.service.Service;

public class ProductTest {
	
	Service ps=new ProductService(); 
	
	@Test
	public void addProduct() {
		Product p=new Product();
		p.setProductName("Realme 6 pro plus");
		p.setProductPrice(25000);
		p.setProductDescription("Oppo is the parent company of RealMe");

		p.setProductName("ASUS ROG Strix");
		p.setProductPrice(90000);
		p.setProductDescription("ROG Strix is a gaming Laptop");
		p.setProductCategory("Laptop");
		ps.add(p);
	}	
	
	@Test
	public void fetchByProductId() {
		Product p=(Product)ps.fetchByPk(222);
		System.out.println(p.getProductId()+p.getProductName()+p.getProductPrice());
		
	}

}
