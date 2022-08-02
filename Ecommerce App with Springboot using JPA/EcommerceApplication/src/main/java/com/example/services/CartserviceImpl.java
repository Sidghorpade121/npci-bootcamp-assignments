package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.Cart;
import com.example.entity.Product;
import com.example.repository.Cartrepository;
import com.example.repository.ProductRepository;

public class CartserviceImpl implements CartService {
	
	@Autowired
	private Cartrepository cartrepo;

	@Override
	public void save(Cart c) {
		// TODO Auto-generated method stub
		cartrepo.save(c);
	}

	

}
