package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.Productcategory;
import com.example.repository.CategoryRepository;



public class ProductcateserviceImpl implements Categoryrservice {
	
	@Autowired
	private CategoryRepository emprepository;
	

	
	public void save(Productcategory e) {
		 emprepository.save(e);	
	}

}
