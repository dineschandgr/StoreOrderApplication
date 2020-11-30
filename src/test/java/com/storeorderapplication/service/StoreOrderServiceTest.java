package com.storeorderapplication.service;


import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.storeorderapplication.model.StoreOrder;
import com.storeorderapplication.repository.StoreOrderRepository;
import com.storeorderapplication.service.StoreOrderService;

@ExtendWith(SpringExtension.class)
class StoreOrderServiceTest {

	@InjectMocks
	private StoreOrderService storeOrderService;
	
    @Mock
    private StoreOrderRepository storeOrderRepository;
    
	@Test
	@DisplayName(value = "Test saveStoreOrders Method")
	void saveStoreOrders() throws ParseException {
		Date date1=new SimpleDateFormat("dd.MM.yy").parse("11.11.16"); 
		StoreOrder storeOrder = new StoreOrder();
	   	storeOrder.setOrderID("CA-2016-152156")
	   	.setOrderDate(date1)
	   	.setShipDate(date1)
	   	.setQuantity(1)
	   	.setProfit(10.00f)
	   	.setProductID("FUR-BO-10001798").setCustomerName("Henderson").setCategory("Furniture")
	   	.setId(1L);
	   	
	   	List<StoreOrder> list = new ArrayList<>();
	   	list.add(storeOrder);
	   	
	   	when(storeOrderRepository.saveAll(list)).thenReturn(list);
	   	List<StoreOrder> orderList = storeOrderService.saveStoreOrders(list);
	   	Assertions.assertEquals(1, orderList.size());
       
	}

}
