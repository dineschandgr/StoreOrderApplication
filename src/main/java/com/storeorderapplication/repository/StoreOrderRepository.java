package com.storeorderapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.storeorderapplication.model.StoreOrder;

/**
 * This class interacts with the database for CRUD operations on StoreOrder data
 *
 */
@Repository
public interface StoreOrderRepository extends JpaRepository<StoreOrder, Long>{

}
