package com.storeorderapplication.util;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.storeorderapplication.model.StoreOrder;

/**
 * This is an interface to parse the file. Every file type parser must implement this interface
 *
 */
@Component
public interface FileParser {
	public List<StoreOrder> parseFile(MultipartFile file);
}
