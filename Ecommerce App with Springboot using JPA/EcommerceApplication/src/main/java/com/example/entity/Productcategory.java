package com.example.entity;





import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ProductCategory")
public class Productcategory {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "catid")
	private Integer categoryId;
	

	@Column(name = "catname")
	private String categoryname;
	
	
	
	public Productcategory() {}
	public Productcategory(Integer categoryId, String categoryname) {
		
		this.categoryId = categoryId;
		this.categoryname = categoryname;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	
	
	
	
	
}
