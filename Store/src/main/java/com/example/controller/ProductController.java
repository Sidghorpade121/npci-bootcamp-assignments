package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Product;
import com.example.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService proService;
	
	@GetMapping("/prolist")
	public String displayProducts(Model model){
		List<Product> pro = proService.findAll();
		model.addAttribute("PRODUCT",pro);
		
		return "proUI/products.html";
	}
	
	
	
	@GetMapping("/addPro")
	public String empForm(Model model) {
		model.addAttribute("PRODUCT",new Product());
		return "proUI/productForm.html";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("PRODUCT") Product pro) {
		
		proService.save(pro);
		
		return "redirect:/product/prolist";
	}
	
	
	@GetMapping("/updateForm")
	public String updateForm(@RequestParam("proId") Integer id, Model model) {
		Product pro = proService.findById(id);
		model.addAttribute("PRODUCT",pro);
		return "proUI/productForm.html";
	}
	
	@GetMapping("/delete")
	public String deleteById(@RequestParam("proId") Integer id) {
		proService.deleteById(id);
		
		return "redirect:/product/prolist";
	}
	
	@GetMapping("/search")
	 public String home(Product shop, Model model, String keyword) {
		  if(keyword!=null) {
		   List<Product> list = proService.getByKeyword(keyword);
		   model.addAttribute("PRODUCT", list);
		  }else {
		  List<Product> list = proService.findAll();
		  model.addAttribute("PRODUCT", list);}
		  return "proUI/products.html";
		 }
	
}
