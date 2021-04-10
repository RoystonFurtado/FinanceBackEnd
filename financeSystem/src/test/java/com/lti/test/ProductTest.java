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
		p.setProductName("Realme 6");
		p.setProductPrice(10000);
		p.setProductDescription("Oppo is the parent company of RealMe");
		ps.add(p);
		
	}
	

}
