package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.entity.Product;
import com.example.repository.ProductRepository;

public class ProductserviceImpl implements Productservice {
	
	@Autowired
	private ProductRepository deprepo;

	@Override
	public void save(Product d) {
		// TODO Auto-generated method stub
		deprepo.save(d);
	}

}
