package com.rest.demo.exception;

public class GameKOException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private  String detalle;
	
	public GameKOException(String detalle) {
		this.detalle = detalle;
	}
	public GameKOException() {
		super();
	}
	public String getDetalle() {
		return detalle;
	}	
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}	
	
}
