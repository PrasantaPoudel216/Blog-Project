package com.backendlearn.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.backendlearn.payloads.Response;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public Response resourceNotFoundExceptionsssss(ResourceNotFoundException ex)
	{
		Response response=new Response();
		response.setMessage(ex.getMessage());
		response.setState(false);
		
		
		return response;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Response methodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		Response response = new Response();
		
		Map<String,String> errmap=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)-> {
			String fieldname=((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errmap.put(fieldname, message);
		});
		
		
		response.setMessage("error!!!!!!!!!!!!!!!!!!!!");
		response.setState(false);
		response.setObject(errmap);
		
		return response;
	}
	
}
