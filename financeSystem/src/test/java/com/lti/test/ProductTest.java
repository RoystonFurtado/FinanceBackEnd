package com.lti.test;

import java.util.List;

import org.junit.Test;

import com.lti.entity.Product;
import com.lti.service.ProductService;
import com.lti.service.Service;

public class ProductTest {
	
	Service ps=new ProductService(); 
	
	@Test
	public void addProduct() {
		Product p=new Product();
		p.setProductName("Realme 6 pro");
		p.setProductPrice(19000);
		p.setProductDescription("Oppo is the parent company of RealMe");

		p.setProductName("ASUS ROG Strix");
		p.setProductPrice(90000);
		p.setProductDescription("ROG Strix is a gaming Laptop");
		p.setProductCategory("Laptop");
		ps.add(p);
	}	
	
	@Test
	public void fetchByProductPrice() {
		ProductService ps1 = new ProductService();
		List<Product> list = (List<Product>) ps1.fetchByProductPrice(19000);
		for(Product l :list) {
			System.out.println(l.getProductName());
		}
		
	}

}
