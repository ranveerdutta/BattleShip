package com.battleship.exception;

public class InvalidShipPositionException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorMsg;

	public InvalidShipPositionException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}
	
	
}
