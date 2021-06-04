package com.awa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awa.entity.Product;

public interface ProductRepository extends JpaRepository <Product, Integer> {

	//Optional<Product> findByName(String name);
	Product findByName(String name);

}
