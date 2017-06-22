package org.mum.edu.mywebservice.Exception;

public class DataNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String msg) {
		
		super(msg);
	}
}
