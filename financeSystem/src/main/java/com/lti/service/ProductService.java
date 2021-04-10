package com.lti.service;

import com.lti.dao.GenericDao;
import com.lti.entity.Product;

public class ProductService implements Service {

	GenericDao dao=new GenericDao();
	
	@Override
	public void add(Object o) {
		dao.save(o);	
	}

	@Override
	public Object fetchByPk(Object o) {
		return (Product)dao.fetchById(Product.class, o);
	}
	

}
