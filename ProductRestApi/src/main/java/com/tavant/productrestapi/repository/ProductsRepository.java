package com.tavant.productrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.productrestapi.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, String>{

}
