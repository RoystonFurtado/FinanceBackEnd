package com.lti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.lti.dao.GenericDao;
import com.lti.entity.Product;

@Component("productService")
public class ProductService implements Service {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("app-config.xml");
	//GenericDao dao=(GenericDao)ctx.getBean("genericDao");
	
	@Autowired
	@Qualifier("genericDao")
	GenericDao dao;
	
	@Override
	@Transactional
	public void add(Object o) {
		dao.save(o);	
	}

	@Override
	public Object fetchByPk(Object o) {
		return (Product) dao.fetchById(Product.class, o);
	}
	
	
	

}
