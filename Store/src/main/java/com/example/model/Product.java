package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import java.sql.Date;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoIncrement
	@Column(name = "proid")
	private Integer id;

	@Column(name = "sku")
	private String sku;

	@Column(name = "proname")
	private String name;

	@Column(name = "prodescription")
	private String desciption;

	@Column(name = "unitprice")
	private Integer unit_price;

	@Column(name = "imageurl")
	private String imageurl;

	@Column(name = "unisInStock")
	private Integer units_in_stock;

	@Column(name = "price")
	private Integer price;

	@Column(name = "datecreated")
	private Date datecreated;

	@Column(name = "lastupdated")
	private Date lastUpdated;

	@Column(name = "categoryId")
	private Integer categoryId;

	public Product() {

	}

	public Product(Integer id, String sku, String name, String desciption, Integer unit_price, String imageurl,
			Integer units_in_stock, Integer price, Date datecreated, Date lastUpdated, Integer categoryId) {
	
		this.id = id;
		this.sku = sku;
		this.name = name;
		this.desciption = desciption;
		this.unit_price = unit_price;
		this.imageurl = imageurl;
		this.units_in_stock = units_in_stock;
		this.price = price;
		this.datecreated = datecreated;
		this.lastUpdated = lastUpdated;
		this.categoryId = categoryId;
	}
	
	public Product( String sku, String name, String desciption, Integer unit_price, String imageurl,
			Integer units_in_stock, Integer price, Date datecreated, Date lastUpdated, Integer categoryId) {
	
		
		this.sku = sku;
		this.name = name;
		this.desciption = desciption;
		this.unit_price = unit_price;
		this.imageurl = imageurl;
		this.units_in_stock = units_in_stock;
		this.price = price;
		this.datecreated = datecreated;
		this.lastUpdated = lastUpdated;
		this.categoryId = categoryId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public Integer getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(Integer unit_price) {
		this.unit_price = unit_price;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public Integer getUnits_in_stock() {
		return units_in_stock;
	}

	public void setUnits_in_stock(Integer units_in_stock) {
		this.units_in_stock = units_in_stock;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	
}
