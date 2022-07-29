package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query(value = "select * from product p where p.proname like %:keyword% or p.category_id like %:keyword% ", nativeQuery = true)
	 List<Product> findByKeyword(@Param("keyword") String keyword);
	

}
