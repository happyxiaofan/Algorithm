package com.rhwayfun.algorithm.linkedlist;

public class OutOfBoundException extends Exception {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public OutOfBoundException(String message){
		this.setMessage(message);
	}
	
	public void printStackTrace(OutOfBoundException e){
		System.out.println(e.getMessage());
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
