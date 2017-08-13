package com.uday.order.model.domain;

import java.math.BigDecimal;

public class OrderSummary {
	private String orderNumber;
	private int itemCount;
	private BigDecimal totalAmount;
	
	public OrderSummary() {
		// TODO Auto-generated constructor stub
	}

	public OrderSummary(String orderNumber, int itemCount, BigDecimal totalAmount) {
		super();
		this.orderNumber = orderNumber;
		this.itemCount = itemCount;
		this.totalAmount = totalAmount;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
