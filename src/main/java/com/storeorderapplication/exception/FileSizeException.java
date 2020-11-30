package com.storeorderapplication.exception;

public class FileSizeException extends RuntimeException {
	  private final String     message;
	  private final String     errorReason;

	  public FileSizeException() {
		this.message = "";
		this.errorReason = "";
		  
	  }
	  public FileSizeException(String message, String errorReason) {
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

