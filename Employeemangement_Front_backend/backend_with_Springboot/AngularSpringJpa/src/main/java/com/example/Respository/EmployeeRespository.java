package com.example.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.entity.Employee;

@RepositoryRestResource(path="emp")
@CrossOrigin("http://localhost:4200/")
public interface EmployeeRespository extends JpaRepository<Employee,Integer> {

}
