package com.lti.test;

import org.junit.Test;

import com.lti.entity.Product;
import com.lti.service.ProductService;
import com.lti.service.Service;

public class ProductTest {
	
	Service ps=new ProductService(); 
	
	@Test
	public void addProduct() {
		Product p=new Product();
		p.setProductName("ASUS ROG Strix");
		p.setProductPrice(90000);
		p.setProductDescription("ROG Strix is a gaming Laptop");
		p.setProductCategory("Laptop");
		ps.add(p);
	}	

}
