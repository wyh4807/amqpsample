package io.hoseo.fbsample;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(RuntimeException re) {
		
		return "redirect:https://http.cat/500";
	}
}
