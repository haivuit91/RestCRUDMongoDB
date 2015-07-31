package com.haivuit.restfull.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import com.haivuit.restfull.mongodb.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

	/**
	 * get list products by sales
	 * 
	 * @param sales
	 * @return list products
	 */
	List<Product> findBySales(@Param("sales") String sales);

}