package net.kzn.onlineshopping1.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public ProductNotFoundException() {
		this("Product is not available!");
	}
	public ProductNotFoundException(String message) {
		
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	
	
	

}//end of class
