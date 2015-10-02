package com.haivuit.restfull.mongodb.service;

import java.util.List;

import com.haivuit.restfull.mongodb.exception.ProductNotFoundException;
import com.haivuit.restfull.mongodb.model.Product;

public interface ProductService {

	/**
	 * get list products
	 * 
	 * @return list products
	 */
	List<Product> getProducts();

	/**
	 * get list product by sales
	 * 
	 * @param sales
	 * @return list products
	 */
	List<Product> getProductsBySales(String sales) throws ProductNotFoundException;

	/**
	 * add new product
	 * 
	 * @param product
	 * @return product
	 */
	Product saveProduct(Product product) throws ProductNotFoundException;

	/**
	 * update product
	 * 
	 * @param product
	 * @return product
	 */
	Product updateProduct(Product product) throws ProductNotFoundException;

	/**
	 * delete product
	 * 
	 * @param id
	 * @return list products
	 */
	List<Product> deleteProduct(String id) throws ProductNotFoundException;

}
