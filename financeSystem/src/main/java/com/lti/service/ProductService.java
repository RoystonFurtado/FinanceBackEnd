package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.GenericDao;
import com.lti.entity.Product;

@Component
public class ProductService implements Service {

	@Autowired
	GenericDao dao;
	
	@Override
	public void add(Object o) {
		dao.save(o);	
	}

	@Override
	public Object fetchByPk(Object o) {
		return (Product) dao.fetchById(Product.class, o);
	}
	
	
	

}
