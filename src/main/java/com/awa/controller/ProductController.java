package com.awa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.awa.entity.Product;
import com.awa.service.ProductService;

@RestController
public class ProductController { //we will write all the end pionts to all the methods in our service
	
	@Autowired
	private ProductService service;
	
	//REST endpionts
	//POST
	@PostMapping("/addProduct")//@requestBody means get the jason object and convert it to my product object
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
}    // POST 
	@PostMapping("/addProducts")
	public List<Product> addProducts( @RequestBody List<Product> products) {
		return service.saveProducts(products);
		}
     //GET API
	@GetMapping("/products")
	public List<Product> findAllProducts() {
		return service.getProduct();
			}
    //GET API
	@GetMapping("/productsById/{id}")//any input we want to pass as part of request url we use @PathVariable
	public Product findProductById(@PathVariable int id) {
		return service.getProductById(id);
			}
    //GET API
	@GetMapping("/products/{name}")
	public Product getProductByName(@PathVariable String name) {
		return service.getProductByName(name);
		}
   
   //DELETE
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
		}
	 //UPDATE
		@PutMapping("/update")
		public Product updateProduct(@RequestBody Product product) {
			return service.updateProduct(product);
		}
}