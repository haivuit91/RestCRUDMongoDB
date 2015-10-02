package com.haivuit.restfull.mongodb.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.SpringApplicationConfiguration;

import com.haivuit.restfull.mongodb.Application;
import com.haivuit.restfull.mongodb.exception.ProductNotFoundException;
import com.haivuit.restfull.mongodb.model.Product;
import com.haivuit.restfull.mongodb.repository.ProductRepository;
import com.haivuit.restfull.mongodb.service.ProductService;
import com.haivuit.restfull.mongodb.service.impl.ProductServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ProductServiceTest {

	@InjectMocks
	private ProductService productService = new ProductServiceImpl();

	@Mock
	private ProductRepository productRepository;

	private Product product = new Product("", "Title 1", "Description", 1.0, "sales1@email.com");

	private List<Product> createProductsList(int i) {
		List<Product> products = new ArrayList<>();
		for (int j = 0; j < i; j++) {
			products.add(new Product("id_" + i, "Title_" + i, "Description_" + i, i, "sales" + i + "@email.com"));
		}
		return products;
	}

	@Before
	public void doSetup() {
		MockitoAnnotations.initMocks(this);

		Mockito.when(productRepository.findAll()).thenReturn(createProductsList(10));

		Mockito.when(productRepository.findBySales(Mockito.anyString())).thenReturn(createProductsList(1));

		Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);

	}

	@Test
	public void testGetProducts() {
		List<Product> products = productService.getProducts();
		Assert.assertEquals(products.size(), 10);
	}

	@Test
	public void testGetProductBySales() throws ProductNotFoundException {
		List<Product> products = productService.getProductsBySales("sales1@email.com");
		Assert.assertEquals(products.size(), 1);
	}

	@Test
	public void testSaveProductAndUpdateProduct() throws ProductNotFoundException {
		Product prod = new Product("", "Title", "Description", 1.0, "sales@email.com");
		Product product = productService.saveProduct(prod);
		Assert.assertNotNull(product);
	}

	@Test
	public void testDeleteProduct() throws ProductNotFoundException {
		String id = "id_1";
		List<Product> products = productService.deleteProduct(id);
		Assert.assertEquals(products.size(), 10);
	}

}
