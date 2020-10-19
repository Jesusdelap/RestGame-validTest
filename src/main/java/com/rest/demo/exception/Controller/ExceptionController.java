package com.rest.demo.exception.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rest.demo.exception.GameDontExistException;
import com.rest.demo.exception.GameKOException;
import com.rest.demo.exception.ValueException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(ValueException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValueException validationError(HttpServletRequest request , ValueException e) {
	
	    return  e;
	}
	
	@ExceptionHandler(GameDontExistException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public GameKOException validationError(HttpServletRequest request , GameDontExistException e) {
			e.setDetalle("Juego no encontrado");
	    return  e;
	}
}
