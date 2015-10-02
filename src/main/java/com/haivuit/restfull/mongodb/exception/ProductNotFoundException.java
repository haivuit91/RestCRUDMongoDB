package com.haivuit.restfull.mongodb.exception;

public class ProductNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String msg) {
		System.out.println(msg);
	}

}
