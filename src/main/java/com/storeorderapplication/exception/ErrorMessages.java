package com.storeorderapplication.exception;


/**
 * This is an enum to store the different error messages
 *
 */
public enum ErrorMessages {
	  FILEDATAEXCEPTION(0, "Order ID, Customer ID or Product ID columns should not contain duplicate values"),
	  FILEFORMATEXCEPTION(1, "Only CSV file format is supported"),
	  FILEVALIDATTIONEXCEPTION(2, "The file data cannot be validated. Please correct the data and uplaod again"),
	  IOEXCEPTION(3, "The file cannot be uploaded. Please try again"),
	  NULLPOINTEREXCEPTION(4, "The file contains null values. Please verify the data and try again"),
	  FILESIZEEXCEPTION(5, "The file size should be between 1 byte to 100 MB"),
	  FILEKEYEXCEPTION(6, "Required request part 'file' key is not present");
	  
	  private final int code;
	  private final String description;

	  private ErrorMessages(int code, String description) {
	    this.code = code;
	    this.description = description;
	  }

	  public String getDescription() {
	     return description;
	  }

	  public int getCode() {
	     return code;
	  }

	  @Override
	  public String toString() {
	    return code + ": " + description;
	  }
	}

