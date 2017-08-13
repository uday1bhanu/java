package com.uday.order.model.transformation;

import java.math.BigDecimal;

import com.uday.order.model.domain.OrderSummary;
import com.uday.order.model.entity.OrderEntity;
import com.uday.order.model.entity.OrderItemEntity;

public class OrderEntityToOrderSummaryTransformation {

	public OrderEntityToOrderSummaryTransformation() {
		
	}
	
	public OrderSummary transform(OrderEntity orderEntity){
		if(orderEntity == null){
			throw new IllegalArgumentException("orderEntity should not be null");
		}
		
		OrderSummary orderSummaryResult = new OrderSummary();
		
		orderSummaryResult.setOrderNumber(orderEntity.getOrderNumber());
		
		int itemCount = 0;
		BigDecimal totalAmount = new BigDecimal("0.0");
		for(OrderItemEntity orderItemEntity : orderEntity.getOrderItemList()){
			itemCount += orderItemEntity.getQuantity();
			BigDecimal value = orderItemEntity.getSellingPrice().multiply(new BigDecimal(orderItemEntity.getQuantity()));
			totalAmount = totalAmount.add(value);
		}
		
		orderSummaryResult.setItemCount(itemCount);
		orderSummaryResult.setTotalAmount(totalAmount);
		return orderSummaryResult;
	}
}
