package com.uday.order.model.service.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import com.uday.common.DataAccessException;
import com.uday.common.ServiceException;
import com.uday.order.dao.OrderDao;
import com.uday.order.integration.WMSUnavailableException;
import com.uday.order.integration.WarehouseManagementService;
import com.uday.order.model.domain.OrderCompletionAudit;
import com.uday.order.model.domain.OrderSummary;
import com.uday.order.model.entity.OrderEntity;
import com.uday.order.model.entity.OrderItemEntity;
import com.uday.order.model.message.ItemMessage;
import com.uday.order.model.message.OrderMessage;
import com.uday.order.model.service.OrderService;
import com.uday.order.model.transformation.OrderEntityToOrderSummaryTransformation;

public class OrderServiceImpl implements OrderService {
	private final static int MAX_INSERT_ATTEMPT = 3;
	private OrderDao orderDao = null;
	private OrderEntityToOrderSummaryTransformation orderEntityToOrderSummaryTransformation = null;
	public OrderServiceImpl() {
	}
	
	

	public OrderServiceImpl(OrderDao orderDao) {
		super();
		this.orderDao = orderDao;
	}



	public OrderServiceImpl(OrderEntityToOrderSummaryTransformation orderEntityToOrderSummaryTransformation) {
		super();
		this.orderEntityToOrderSummaryTransformation = orderEntityToOrderSummaryTransformation;
	}



	public OrderDao getOrderDao() {
		return orderDao;
	}



	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}



	public OrderEntityToOrderSummaryTransformation getOrderEntityToOrderSummaryTransformation() {
		return orderEntityToOrderSummaryTransformation;
	}



	public void setOrderEntityToOrderSummaryTransformation(
			OrderEntityToOrderSummaryTransformation orderEntityToOrderSummaryTransformation) {
		this.orderEntityToOrderSummaryTransformation = orderEntityToOrderSummaryTransformation;
	}



	public List<OrderSummary> getOrderSummary(long customerId) throws ServiceException {
		List<OrderSummary> orderSummaryList = new LinkedList<OrderSummary>();
		try{
			List<OrderEntity> orderEntityList = this.orderDao.findOrdersByCustomer(customerId);
			for(OrderEntity orderEntity : orderEntityList){
				OrderSummary orderSummary = this.orderEntityToOrderSummaryTransformation.transform(orderEntity);
				orderSummaryList.add(orderSummary);
			}
		}
		catch(DataAccessException ex){
			throw new ServiceException("Data access error occured", ex);
		}
		return orderSummaryList;
	}
	
	public String openNewOrder(long customerId) throws ServiceException {
		OrderEntity newOrderEntity = new OrderEntity();
		newOrderEntity.setCustomerId(customerId);
		newOrderEntity.setOrderNumber(UUID.randomUUID().toString());
		
		boolean insertSuccessful = false;
		int insertAttempt = 1;
		while(!insertSuccessful && insertAttempt <= MAX_INSERT_ATTEMPT){
			try{
				System.out.println("before insert");
				int resultValue = orderDao.insert(newOrderEntity);
				if(resultValue == 1){
					insertSuccessful = true;
					System.out.println("insert success");
				}
				else{
					++insertAttempt;
					System.out.println("insertAttempt ++");
				}
			}
			catch(DataAccessException ex){
				++insertAttempt;
				System.out.println("Caught ex insertAttempt++ "+ ex);
			}
		}
		
		if(!insertSuccessful){
			System.out.println("insert not sucess even after retires. throw data acess exception");
			throw new ServiceException("Data access error prevented creation of order");
		}
		
		return newOrderEntity.getOrderNumber(); 
	}
	
	public void completeOrder(long orderId) throws ServiceException{
		try{
			OrderEntity orderEntity = orderDao.findById(orderId);
			OrderMessage orderMessage = new OrderMessage();
			orderMessage.setOrderNumber(orderEntity.getOrderNumber());
			orderMessage.setItems(new LinkedList<ItemMessage>());
			for(OrderItemEntity orderItemEntity : orderEntity.getOrderItemList()){
				ItemMessage itemMessage = new ItemMessage();
				itemMessage.setItemNumber(orderItemEntity.getSku());
				itemMessage.setQuantity(orderItemEntity.getQuantity());
				orderMessage.getItems().add(itemMessage);
			}
			
			WarehouseManagementService.sendOrder(orderMessage);
			Date completionDate = new Date();
			OrderCompletionAudit orderCompletionAudit = new OrderCompletionAudit();
			orderCompletionAudit.setCompletionDate(completionDate);
			orderCompletionAudit.setOrderNumber(orderEntity.getOrderNumber());
			
		}
		catch(DataAccessException ex){
			throw new ServiceException("Data access error while completing the order", ex);
		}
		catch(WMSUnavailableException ex){
			throw new ServiceException("WMS was unavailable when sending the order", ex);
		}
	}

}
