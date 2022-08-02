package com.example.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoIncrement
	@Column(name = "cartid")
	private Integer id;
	
	@Column(name = "prodid")
	private Integer proid;

	@Column(name = "proname")
	private String name;
;

	@Column(name = "price")
	private Integer price;

	@Column(name = "qty")
	private Integer qty;


	public Cart() {

	}


	public Cart(Integer id, Integer proid, String name, Integer price, Integer qty) {
		super();
		this.id = id;
		this.proid = proid;
		this.name = name;
		this.price = price;
		this.qty = qty;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getProid() {
		return proid;
	}


	public void setProid(Integer proid) {
		this.proid = proid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public Integer getQty() {
		return qty;
	}


	public void setQty(Integer qty) {
		this.qty = qty;
	}

	

	
}
