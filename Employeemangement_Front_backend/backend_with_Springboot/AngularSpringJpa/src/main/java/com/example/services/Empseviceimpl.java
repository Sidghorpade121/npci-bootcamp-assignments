package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Respository.EmployeeRespository;
import com.example.entity.Employee;



public class Empseviceimpl implements Empservice {
	
	@Autowired
	private EmployeeRespository emprepository;
	

	
	public void save(Employee e) {
		 emprepository.save(e);	
	}

}
