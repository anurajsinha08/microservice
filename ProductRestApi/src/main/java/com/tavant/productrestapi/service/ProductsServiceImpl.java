package com.tavant.productrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.productrestapi.model.Products;
import com.tavant.productrestapi.repository.ProductsRepository;
@Service

public class ProductsServiceImpl implements ProductsService {

	@Autowired
	ProductsRepository productsRepository;

	@Override
	public boolean addProducts(Products products) {

		Products prod = productsRepository.save(products);
		return prod!=null;
	}

	@Override
	public Optional<Products> updateProduct(String prodCode, Products products) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProduct(String prodCode) {
		
		if(productsRepository.existsById(prodCode)) {
			productsRepository.deleteById(prodCode);
			return "success";
		}
		return "fail";
	}

	@Override
	public Optional<Products> getProductById(String prodCode) {
		// TODO Auto-generated method stub
		return productsRepository.findById(prodCode);
	}

	@Override
	public Optional<List<Products>> getProducts() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(productsRepository.findAll());
	}

	@Override
	public boolean ProductExistById(String prodCode) {
		// TODO Auto-generated method stub
		return productsRepository.existsById(prodCode);
	}
}