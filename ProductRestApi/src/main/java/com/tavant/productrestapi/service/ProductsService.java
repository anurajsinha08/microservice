package com.tavant.productrestapi.service;

import java.util.List;
import java.util.Optional;

import com.tavant.productrestapi.model.Products;

public interface ProductsService {

	public boolean addProducts(Products products);
	public Optional<Products> updateProduct(String prodCode, Products products);
	public String deleteProduct(String prodCode);
	public Optional<Products> getProductById(String prodCode);
	public Optional<List<Products>> getProducts();
	public boolean ProductExistById(String prodCode);
}
