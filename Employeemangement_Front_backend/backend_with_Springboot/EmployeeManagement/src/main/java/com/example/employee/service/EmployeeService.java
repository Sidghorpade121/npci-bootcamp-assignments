package com.example.employee.service;

import java.util.List;

import com.example.employee.entity.Employee;

public interface EmployeeService {

	public List <Employee> findAll();
	
	 void save(Employee employee);
}
