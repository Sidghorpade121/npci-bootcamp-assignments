package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Respository.DepartmenrRepository;
import com.example.entity.Department;

public class Depatserviceimpl implements Deptservice {
	
	@Autowired
	private DepartmenrRepository deprepo;

	@Override
	public void save(Department d) {
		// TODO Auto-generated method stub
		deprepo.save(d);
	}

}
