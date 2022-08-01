package com.example.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository emprepo;
	

	public List<Employee> findAll() {
		return emprepo.findAll();
		
	}


	
	 @Override
	    public void save(Employee emp) {
		 emprepo.save(emp);
	    }

}
