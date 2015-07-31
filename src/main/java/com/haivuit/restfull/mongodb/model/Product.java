package com.haivuit.restfull.mongodb.model;

import org.springframework.data.annotation.Id;

public class Product {

	@Id
	private String id;

	private String title;

	private String description;

	private double price;

	private String sales;

	public Product() {
	}

	public Product(String id, String title, String description, double price, String sales) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.sales = sales;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}

}
