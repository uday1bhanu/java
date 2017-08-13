package com.uday.order.model.service.impl;

import java.util.LinkedList;
import java.util.List;

import com.uday.common.DataAccessException;
import com.uday.common.ServiceException;
import com.uday.order.dao.OrderDao;
import com.uday.order.model.domain.OrderSummary;
import com.uday.order.model.entity.OrderEntity;
import com.uday.order.model.service.OrderService;
import com.uday.order.model.transformation.OrderEntityToOrderSummaryTransformation;

public class OrderServiceImpl implements OrderService {
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

}
