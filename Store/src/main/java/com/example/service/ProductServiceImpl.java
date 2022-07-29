package com.example.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repository.ProductRepository;



@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		
		return repository.findAll(); // 
	}

	
	public void save(Product p) {
		 repository.save(p);	
	}


	
	public Product findById(Integer id) {
		
		Optional<Product> p =  repository.findById(id) ;
		Product emp = null;
		
		if(p.isPresent())
			emp = p.get();
		
		return emp;
	}


	
	public void deleteById(Integer id) {
		repository.deleteById(id);
		
	}


	public List<Product> getByKeyword(String keyword){
		  return repository.findByKeyword(keyword);
		 }
		
	}
	
