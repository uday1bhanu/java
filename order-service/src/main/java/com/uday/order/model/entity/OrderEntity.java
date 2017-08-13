package com.uday.order.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OrderEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private String orderNumber;
	
	@Column
	private String orderLabel;
	
	@Column
	private long customerId;
	
	@Column
	private long shippingAddressId;
	
	@Column
	private long billingAddressId;
	
	@Column
	private Date completionDate;
	
	@OneToMany
	private List<OrderItemEntity> orderItemList = new ArrayList<OrderItemEntity>();
	
	public OrderEntity() {
		// TODO Auto-generated constructor stub
	}

	public OrderEntity(long id, String orderNumber, String orderLabel, long customerId, long shippingAddressId,
			long billingAddressId, Date completionDate, List<OrderItemEntity> orderItemList) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.orderLabel = orderLabel;
		this.customerId = customerId;
		this.shippingAddressId = shippingAddressId;
		this.billingAddressId = billingAddressId;
		this.completionDate = completionDate;
		this.orderItemList = orderItemList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderLabel() {
		return orderLabel;
	}

	public void setOrderLabel(String orderLabel) {
		this.orderLabel = orderLabel;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(long shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public long getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(long billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public List<OrderItemEntity> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItemEntity> orderItemList) {
		this.orderItemList = orderItemList;
	}

}
