package com.lti.service;

import com.lti.dao.GenericDao;
import com.lti.entity.Product;
import com.lti.dao.ProductDao;
public class ProductService implements Service {

	GenericDao dao=new GenericDao();
	ProductDao dao1 = new ProductDao();
	@Override
	public void add(Object o) {
		dao.save(o);	
	}

	@Override
	public Object fetchByPk(Object o) {
		return (Product)dao.fetchById(Product.class, o);
	}
	
	public Product fetchByProductPrice(double price) {
		return (Product)dao1.fetchByProductPrice(price);
		
	}
	

}
