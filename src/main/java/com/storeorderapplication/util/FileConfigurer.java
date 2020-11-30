package com.storeorderapplication.util;

import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.storeorderapplication.exception.FileFormatException;
import com.storeorderapplication.exception.FileSizeException;
import com.storeorderapplication.model.StoreOrder;

/**
 * This is a helper class to validate the file and send the file to parser to parse data
 */
@Component
public class FileConfigurer {
	
	/**
	 * This method validates the file and then calls the File Parser to parse the data
	 * @param file -  Multipart file of StoreOrder data
	 * @return List<StoreOrder> - the list of parsed StoreOrder data
	 */
	public List<StoreOrder> validateFile(MultipartFile file){
		
		FileParser fileParser = null;
		
		if(file.getSize() <= 0 || file.getSize() >= 1_048_576)
			throw new FileSizeException();
			
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		
		if(extension.equalsIgnoreCase("csv"))
			fileParser = new CsvFileParser();
		else
			throw new FileFormatException();
		
		return fileParser.parseFile(file);
		
	}
	
}
