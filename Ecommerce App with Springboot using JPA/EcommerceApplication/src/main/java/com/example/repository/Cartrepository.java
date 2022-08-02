package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.entity.Cart;
import com.example.entity.Productcategory;

@RepositoryRestResource(path="cart")
@CrossOrigin("http://localhost:4200/")
public interface Cartrepository extends JpaRepository<Cart,Integer> {

}