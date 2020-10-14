package com.rest.demo.exception;

public class GameDontExistException extends GameKOException {

	public GameDontExistException(String detalle) {
		super(detalle);
	}
	public GameDontExistException( ) {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
