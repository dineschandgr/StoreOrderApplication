package com.storeorderapplication.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.storeorderapplication.exception.FileDataException;
import com.storeorderapplication.model.StoreOrder;

/**
 * This class implements the File Parser and it is used to parse the csv file 
 *
 */
@Component
public class CsvFileParser implements FileParser {

	/**
	 *This method is used to parse the csv file and store every record data as StoreOrder entity
	 *It also validates the data for null and also the duplicates for Order ID, Customer ID and Product ID
	 *@param file -  Multipart file of StoreOrder data
	 *@return List<StoreOrder> - the list of StoreOrder data
	 */
	@Override
	public List<StoreOrder> parseFile(MultipartFile file) {

		 List<StoreOrder> storeOrders = new ArrayList<StoreOrder>();
		try(
			Reader reader = new InputStreamReader(file.getInputStream());
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
				         .withFirstRecordAsHeader()
				         .withIgnoreHeaderCase()
				         .withTrim());){
	         SimpleDateFormat date = new SimpleDateFormat("dd.MM.yy");
	         
	         Set<String> orderIdSet = new HashSet<String>();
	         Set<String> productIdSet = new HashSet<String>();
	         Set<String> customerIdSet = new HashSet<String>();
	         
	         for (CSVRecord csvRecord : csvParser) {
	             StoreOrder storeOrder = new StoreOrder();
		    		 String orderID = csvRecord.get("Order ID");
		    		 String productID = csvRecord.get("Product ID");
		    		 String customerID = csvRecord.get("Customer ID");
		    		 String orderDate = csvRecord.get("Order Date");
		    		 String shipDate = csvRecord.get("Ship Date");
		    		 String customerName = csvRecord.get("Customer Name");
		    		 String category = csvRecord.get("Category");
		    		 String quantity = csvRecord.get("Quantity");
		    		 String profit = csvRecord.get("Profit");
		    		
		    		 if(StringUtils.isEmpty(orderID) || StringUtils.isEmpty(productID) || StringUtils.isEmpty(customerID) || StringUtils.isEmpty(orderDate) || StringUtils.isEmpty(shipDate)
		    				 || StringUtils.isEmpty(customerName) || StringUtils.isEmpty(category) || StringUtils.isEmpty(quantity) || StringUtils.isEmpty(profit))
		    			 throw new NullPointerException();
		    		 
		    		 if(orderIdSet.contains(orderID) || productIdSet.contains(productID) || customerIdSet.contains(customerID))
		    			 throw new FileDataException();
		    		 
		    		 orderIdSet.add(orderID);
		    		 productIdSet.add(productID);
		    		 customerIdSet.add(customerID);
		    		 
					storeOrder
					 .setOrderID(orderID)
					 .setOrderDate(date.parse(orderDate))
					 .setShipDate(date.parse(shipDate))
					 .setShipMode(csvRecord.get("Ship Mode"))
					 .setQuantity(Integer.parseInt(quantity))
					 .setDiscount(Float.parseFloat(csvRecord.get("Discount")))
					 .setProfit(Float.parseFloat(profit))
					 .setProductID(productID)
					 .setCustomerName(customerName)
					 .setCategory(category)
					 .setCustomerID(customerID)
					 .setProductName(csvRecord.get("Product Name"));
					
					storeOrders.add(storeOrder);
			} 
		}catch (ParseException | IOException ex) {
			ex.printStackTrace();
		}
	    
        return storeOrders;
	}
         
}
