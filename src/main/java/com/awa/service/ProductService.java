package com.awa.service;

import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awa.entity.Product;
import com.awa.exception.ProductNotFoundException;
import com.awa.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	//***************POST save a single product object*********************************************************
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	//POST saveAll list of products
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
		}

	//***************GET return a single product object*********************************************************
	public Product getProductById(int id) {
		return repository.findById(id).orElse(null); //return the id or return null
		}
	
	public Product getProductsById(int id) {
		//return repository.findById(id).orElseThrow(null);
		return repository.findById(id).orElseThrow(()-> new ProductNotFoundException("user id not found with"+id));
		}
		//GET return list of products
	public List<Product> getProduct() {
		return repository.findAll();
			}
	//GET return a single product object
		public Product getProductByName(String name) {
			return repository.findByName(name);
            }

      //*********************Update. there is no update method in spring data jpa*******************************
		public Product updateProduct(Product product) {
			//Product existingProduct=repository.findById(product.getId()).orElse(null);
			Product existingProduct=repository.findById(product.getId())
			.orElseThrow(()-> new ProductNotFoundException("user id not found with"+product));
			existingProduct.setName(product.getName());
			existingProduct.setQuantity(product.getQuantity());
			existingProduct.setPrice(product.getPrice());
			return repository.save(existingProduct);
		}
      //***********************delete************************************************************************
		public String deleteProduct(int id) {
				repository.deleteById(id);
				return "Product removed" +id;
		}





}