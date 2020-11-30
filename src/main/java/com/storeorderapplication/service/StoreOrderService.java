package com.storeorderapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storeorderapplication.model.StoreOrder;
import com.storeorderapplication.repository.StoreOrderRepository;

	/**
	 * This is the service class which interacts with the repository layer to store the StoreOrder order to database
	 */
	@Service
	public class StoreOrderService {
	
		@Autowired
		StoreOrderRepository storeOrderRepository;
	
		/**
		 * This method saves the List of StoreOrder objects to the Database
		 * @param storeOrders - List of StoreOrder Objects
		 * @return List<StoreOrder> - List of saved StoreOrder Objects
		 */
		public List<StoreOrder> saveStoreOrders(List<StoreOrder> storeOrders) {
			System.out.println("processStoreOrders "+storeOrders.size());
			return storeOrderRepository.saveAll(storeOrders);
		}

	}
