package com.storeorderapplication.exception;

import java.io.IOException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import com.sun.el.parser.ParseException;


/**
 * This class handles all the exceptions thrown by the application and wraps them into ErrorResponse message 
 * for easy readability of the users
 *
 */
@RestControllerAdvice
public class StoreOrderExceptionHandler {
		
	
	    /**
	     * This method catches the FileDataException thrown by the application
	     * @param ex - exception object
	     * @return ErrorResponse object with a error message and the status
	     */
	    @ExceptionHandler(value = { FileDataException.class, DataIntegrityViolationException.class })
	    @ResponseStatus(HttpStatus.CONFLICT)
	    public ErrorResponse fileDataException(Exception ex)
	    {
	    	System.out.println("ssss");
			ErrorResponse responseMsg = new ErrorResponse(ErrorMessages.FILEDATAEXCEPTION.getDescription(), HttpStatus.CONFLICT.value());
	        return responseMsg;
	    }
		
	    /**
	     * This method catches the FileFormatException thrown by the application
	     * @param ex - exception object
	     * @return ErrorResponse object with a error message and the status
	     */
		@ExceptionHandler(value = { FileFormatException.class })
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ErrorResponse fileFormatException(Exception ex)
	    {
			ErrorResponse responseMsg = new ErrorResponse(ErrorMessages.FILEFORMATEXCEPTION.getDescription(), HttpStatus.BAD_REQUEST.value());
	        return responseMsg;
	    }
		
		/**
	     * This method catches the NumberFormatException thrown by the application
	     * @param ex - exception object
	     * @return ErrorResponse object with a error message and the status
	     */
		@ExceptionHandler(value = { NumberFormatException.class, ParseException.class})
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ErrorResponse numberFormatException(Exception ex)
	    {
			ErrorResponse responseMsg = new ErrorResponse(ErrorMessages.NULLPOINTEREXCEPTION.getDescription(), HttpStatus.BAD_REQUEST.value());
	        return responseMsg;
	    }
		
		/**
	     * This method catches the IOException thrown by the application
	     * @param ex - exception object
	     * @return ErrorResponse object with a error message and the status
	     */
		@ExceptionHandler(value = { IOException.class })
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ErrorResponse ioException(Exception ex)
	    {
			ErrorResponse responseMsg = new ErrorResponse(ErrorMessages.IOEXCEPTION.getDescription(), HttpStatus.BAD_REQUEST.value());
	        return responseMsg;
	    }
		
		/**
	     * This method catches the NullPointerException thrown by the application
	     * @param ex - exception object
	     * @return ErrorResponse object with a error message and the status
	     */
		@ExceptionHandler(value = { NullPointerException.class })
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ErrorResponse nullPointerException(Exception ex)
	    {
			ErrorResponse responseMsg = new ErrorResponse(ErrorMessages.NULLPOINTEREXCEPTION.getDescription(), HttpStatus.BAD_REQUEST.value());
	        return responseMsg;
	    }
		
		/**
	     * This method catches the FileSizeException thrown by the application
	     * @param ex - exception object
	     * @return ErrorResponse object with a error message and the status
	     */
		@ExceptionHandler(value = { FileSizeException.class })
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ErrorResponse fileSizeException(Exception ex)
	    {
			ErrorResponse responseMsg = new ErrorResponse(ErrorMessages.FILESIZEEXCEPTION.getDescription(), HttpStatus.BAD_REQUEST.value());
	        return responseMsg;
	    }
		
		/**
	     * This method catches the MissingServletRequestPartException thrown by the application
	     * @param ex - exception object
	     * @return ErrorResponse object with a error message and the status
	     */
		@ExceptionHandler(value = { MissingServletRequestPartException.class })
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ErrorResponse multiPartException(Exception ex)
	    {
			ErrorResponse responseMsg = new ErrorResponse(ErrorMessages.FILEKEYEXCEPTION.getDescription(), HttpStatus.BAD_REQUEST.value());
	        return responseMsg;
	    }
	}
