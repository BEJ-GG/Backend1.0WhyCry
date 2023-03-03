package exceptions;

import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ErrorException  extends RuntimeException{
	
	private HttpStatus status;
	private Date timestamp;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ErrorException.class);

	public ErrorException() {
		super();
		this.timestamp = new Date();
		LOGGER.warn(Arrays.toString(getStackTrace()));
	}
	
	public ErrorException(String message) {
		super(message);
		this.timestamp = new Date();
		LOGGER.warn(Arrays.toString(getStackTrace()));
	}
	
	public ErrorException(String message, HttpStatus status) {
		super(message);
		this.status = status;
		this.timestamp = new Date();
		LOGGER.warn(Arrays.toString(getStackTrace()));
	}
	

}
