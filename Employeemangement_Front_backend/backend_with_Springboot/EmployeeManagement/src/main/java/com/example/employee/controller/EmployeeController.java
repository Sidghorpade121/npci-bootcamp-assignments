package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;



@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empservice;
	
	@GetMapping("/emplist")
	public String displayAll(Model model) {
		List<Employee> emp = empservice.findAll();
		model.addAttribute("EMPLOYEE",emp);
		
		return "empUI/employees.html";
	}
	
	@RequestMapping("/new")
    public String showNewEmployeePage(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "empUI/new_employee.html";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee, Model model, BindingResult result) {
    	empservice.save(employee);
      
      
        model.addAttribute("employeeAttr", employee);
        return "empUI/employees.html";
    }
	
}
