package com.tavant.productrestapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.productrestapi.exception.NoProductFoundException;
import com.tavant.productrestapi.exception.ProductNotFoundException;
import com.tavant.productrestapi.model.Products;
import com.tavant.productrestapi.service.ProductsService;

//To perform the work of controller if we are using spring MVC
// then we will use @Controller
// but here we are using rest then
// we should use @RestController

//This annotation is introduced from spring mvc version 4.x
// before spring 3.0 was a combination of
//@ResponseEntity and @Controller
// in 4.0 they form @RestController
// When we will deal with any rest application there we have to
// send the response will be a json,html,xml, or any file
// wherever we have to share the data there we have to mark @repository
// then what they have done instead of marking it on each and every method
// they come up with a solution @RestController

@RestController
//@RequestMapping("/api/product")
// This means that here we have the resources for employee
public class ProductController {

	@Autowired
	ProductsService productService;
	
	@GetMapping("/all")
	//	//This method should return all employees but in terms of json array
	public Optional<List<Products>> getProduct() throws NoProductFoundException{
		Optional<List<Products>> p = productService.getProducts();
		if(p.get().size()==0) {
			throw new NoProductFoundException("No Product Data Exist");
		}
		else {
			return p;
		}
	}
	
	
	//To get record of specific id
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") String productId) throws ProductNotFoundException {

		Optional<Products> p = productService.getProductById(productId);

		if(p.isPresent()) {
			return ResponseEntity.ok(p.get());
		}
		else {
			throw new ProductNotFoundException("Product Not Found");	
		}
	}
	
	@PostMapping("/add")
	public boolean addProduct(@RequestBody @Valid Products product) {
		return productService.addProducts(product);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") String productId) throws ProductNotFoundException {

		String p = productService.deleteProduct(productId);

		if(p.equals("success")) {
			return ResponseEntity.ok(p);
		}
		else {
			throw new ProductNotFoundException("Product Not Found");	
		}
	}
	
}
