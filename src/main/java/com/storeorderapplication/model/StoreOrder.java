package com.storeorderapplication.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * This is the entity class used by hibernate to persist StoreOrder data to STORE_ORDER table
 *
 */
@Entity
@Table(name = "STORE_ORDER")
public class StoreOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID",unique = true)
	private Long id;
	
	@Column(name = "ORDER_ID",unique = true)
	private String orderID;
	
	@Column(name = "ORDER_DATE")
	private Date orderDate;
	
	@Column(name = "SHIP_DATE")
	private Date shipDate;
	
	@Column(name = "SHIP_MODE")
	private String shipMode;

	@Column(name = "QUANTITY")
	private int quantity;
	
	@Column(name = "DISCOUNT", precision = 3, scale = 2)
	private float discount;
	
	@Column(name = "PROFIT", precision = 6, scale = 2)
	private float profit;
	
	@Column(name = "PRODUCT_ID", unique = true)
	private String productID;
	
	private String customerName;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "CUSTOMER_ID", unique = true)
	private String customerID;
	
	@Column(name = "PRODUCT_NAME")
	private String productName;
	
    public Long getId() {
        return id;
    }
	
	public String getOrderID() {
		return orderID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public String getShipMode() {
		return shipMode;
	}

	public int getQuantity() {
		return quantity;
	}

	public float getDiscount() {
		return discount;
	}

	public float getProfit() {
		return profit;
	}

	public String getProductID() {
		return productID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCategory() {
		return category;
	}

	@Column(name="CUSTOMER_ID")
	public String getCustomerID() {
		return customerID;
	}

	public String getProductName() {
		return productName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StoreOrder setOrderID(String orderID) {
		this.orderID = orderID;
		return this;
	}

	public StoreOrder setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
		return this;
	}

	public StoreOrder setShipDate(Date shipDate) {
		this.shipDate = shipDate;
		return this;
	}

	public StoreOrder setShipMode(String shipMode) {
		this.shipMode = shipMode;
		return this;
	}

	public StoreOrder setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public StoreOrder setDiscount(float discount) {
		this.discount = discount;
		return this;
	}

	public StoreOrder setProfit(float profit) {
		this.profit = profit;
		return this;
	}

	public StoreOrder setProductID(String productID) {
		this.productID = productID;
		return this;
	}

	public StoreOrder setCustomerName(String customerName) {
		this.customerName = customerName;
		return this;
	}

	public StoreOrder setCategory(String category) {
		this.category = category;
		return this;
	}

	public StoreOrder setCustomerID(String customerID) {
		this.customerID = customerID;
		return this;
	}

	public StoreOrder setProductName(String productName) {
		this.productName = productName;
		return this;
	}
	
}
