package com.storeorderapplication.exception;

public class FileFormatException extends RuntimeException {
	  private final String     message;
	  private final String     errorReason;

	  public FileFormatException() {
		this.message = "";
		this.errorReason = "";
		  
	  }
	  public FileFormatException(String message, String errorReason) {
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

