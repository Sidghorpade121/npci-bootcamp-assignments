package com.example.service;

import java.util.List;

import com.example.model.Product;


public interface ProductService {

	public List<Product> findAll();
	public void save(Product p);
	public Product findById(Integer id);
	public void deleteById(Integer id);
	public List<Product> getByKeyword(String keyword);	
}
