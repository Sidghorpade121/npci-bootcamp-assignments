package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.entity.Productcategory;

@RepositoryRestResource(path="cat")
@CrossOrigin("http://localhost:4200/")
public interface CategoryRepository extends JpaRepository<Productcategory,Integer> {

}
