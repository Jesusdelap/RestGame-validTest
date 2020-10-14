package com.rest.demo.exception;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ValueException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	
	private String description;
	
	private List<FieldError> fieldErrors;
	
	
	@Autowired
	public ValueException(String description, List<FieldError> fieldErrors) {
		super();
		this.description = description;
		this.fieldErrors = fieldErrors;
	}

	public ValueException() {
		// TODO Auto-generated constructor stub
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	@Override
	public String toString() {
		return "ValueException [description=" + description + ", fieldErrors=" + fieldErrors + "]";
	}
	
	


	
	
	
	
	
}
