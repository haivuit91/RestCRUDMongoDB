package com.haivuit.restfull.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haivuit.restfull.mongodb.exception.ProductNotFoundException;
import com.haivuit.restfull.mongodb.model.Product;
import com.haivuit.restfull.mongodb.service.ProductService;

@RestController
@RequestMapping("/products/")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * get all product
	 * 
	 * @return list products
	 */
	@RequestMapping("get-all")
	public List<Product> getProducts() {
		return productService.getProducts();
	}

	@RequestMapping(value = "get-by-sales")
	public List<Product> getProductsBySales(@RequestParam("sales") String sales) throws ProductNotFoundException {
		return productService.getProductsBySales(sales);
	}

	@RequestMapping(value = "save-product", method = RequestMethod.POST, params = MediaType.APPLICATION_JSON_VALUE)
	public Product saveProduct(@RequestBody Product product) throws ProductNotFoundException {
		return productService.saveProduct(product);
	}

	@RequestMapping(value = "update-product", method = RequestMethod.PUT, params = MediaType.APPLICATION_JSON_VALUE)
	public Product updateProduct(@RequestBody Product product) throws ProductNotFoundException {
		return productService.updateProduct(product);
	}

	@RequestMapping(value = "delete-product", method = RequestMethod.DELETE, params = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> deleteProduct(@RequestParam String id) throws ProductNotFoundException {
		return productService.deleteProduct(id);
	}

}
