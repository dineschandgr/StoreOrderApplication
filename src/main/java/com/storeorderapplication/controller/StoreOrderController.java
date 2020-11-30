package com.storeorderapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.storeorderapplication.model.StoreOrder;
import com.storeorderapplication.service.StoreOrderService;
import com.storeorderapplication.util.FileConfigurer;

 
/**
 * 
 * This controller provides API to to save the uploaded Store Order files
 */
@RestController
@RequestMapping("/api")
public class StoreOrderController {

	@Autowired
	FileConfigurer fileConfigurer;
	
	@Autowired
	StoreOrderService storeOrderService;
	
	String status = "Upload Success";
	
	/**
	 * This API takes a multipart file as input
	 * and saves the data to DB
	 * @param file - Multipart file of StoreOrder data
	 * @return ResponseEntity with the upload status
	 */
	@RequestMapping(value = "/uploadStoreOrder", method = RequestMethod.POST)
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
	     List<StoreOrder> storeOrders = fileConfigurer.validateFile(file);
	     storeOrderService.saveStoreOrders(storeOrders);
	     return new ResponseEntity<String>(status,HttpStatus.OK);
	}
}
