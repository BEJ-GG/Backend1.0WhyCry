package exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {

	@ExceptionHandler(value = {ErrorException.class})
	public ErrorException erroException(ErrorException e) {
		return new ErrorException(e.getMessage(), e.getStatus());
	}
}
