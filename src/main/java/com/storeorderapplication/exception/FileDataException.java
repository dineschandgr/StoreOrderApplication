package com.storeorderapplication.exception;

public class FileDataException extends RuntimeException {
	  private final String message;
	  private final String errorReason;

	  public FileDataException() {
		this.message = "";
		this.errorReason = "";
		  
	  }
	  public FileDataException(String message, String errorReason) {
	    this.message = message;
	    this.errorReason = errorReason;
	  }

	  @Override
	  public String getMessage() {
	    return message;
	  }

	  public String getErrorReason() {
	    return errorReason;
	  }
	}

