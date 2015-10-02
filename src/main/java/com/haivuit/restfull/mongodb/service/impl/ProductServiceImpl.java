package com.haivuit.restfull.mongodb.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haivuit.restfull.mongodb.exception.ProductNotFoundException;
import com.haivuit.restfull.mongodb.model.Product;
import com.haivuit.restfull.mongodb.repository.ProductRepository;
import com.haivuit.restfull.mongodb.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getProductsBySales(String sales) throws ProductNotFoundException {
		if (StringUtils.isBlank(sales)) {
			throw new ProductNotFoundException("Sales is not empty");
		}
		List<Product> products = productRepository.findBySales(sales);
		return products;
	}

	@Override
	@Transactional
	public Product saveProduct(Product product) throws ProductNotFoundException {
		if (product == null) {
			throw new ProductNotFoundException("Product cannot be null");
		}
		Product prod = productRepository.save(product);
		return prod;
	}

	@Override
	@Transactional
	public Product updateProduct(Product product) throws ProductNotFoundException {
		if (product == null) {
			throw new ProductNotFoundException("Product cannot be null");
		}
		Product prod = productRepository.save(product);
		return prod;
	}

	@Override
	@Transactional
	public List<Product> deleteProduct(String id) throws ProductNotFoundException {
		if (StringUtils.isBlank(id)) {
			throw new ProductNotFoundException("Id product is not empty");
		}
		productRepository.delete(id);
		return getProducts();
	}

}
