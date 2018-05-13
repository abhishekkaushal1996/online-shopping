package com.mabhi.onlineshopping.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public String getMessage() {
		return message;
	}

	public ProductNotFoundException() {
		this("product is not available!");
	}

	public ProductNotFoundException(String message) {
		this.message=System.currentTimeMillis()+" : "+message; 
	}
}
