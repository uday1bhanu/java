package com.uday.order.model.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.uday.common.DataAccessException;
import com.uday.common.ServiceException;
import com.uday.order.dao.OrderDao;
import com.uday.order.model.domain.OrderSummary;
import com.uday.order.model.entity.OrderEntity;
import com.uday.order.model.transformation.OrderEntityToOrderSummaryTransformation;

import junit.framework.Assert;

public class OrderServiceImplTest {
	private final static long CUSTOMER_ID = 1L;
	
	@Test
	public void test_getOrderSummary_success() throws ServiceException, DataAccessException{
		//Setup
		OrderServiceImpl target = new OrderServiceImpl();
		
		OrderDao mockOrderDao = Mockito.mock(OrderDao.class);
		target.setOrderDao(mockOrderDao);
		
		OrderEntityToOrderSummaryTransformation mockOrderEntityToOrderSummaryTransformation = Mockito.mock(OrderEntityToOrderSummaryTransformation.class);
		target.setOrderEntityToOrderSummaryTransformation(mockOrderEntityToOrderSummaryTransformation);
		
		OrderEntity orderEntity = new OrderEntity();
		List<OrderEntity> orderEntities = new LinkedList<OrderEntity>();
		orderEntities.add(orderEntity);
		
		//Stub
		Mockito.when(mockOrderDao.findOrdersByCustomer(CUSTOMER_ID)).thenReturn(orderEntities);
		OrderSummary orderSummary = new OrderSummary();
		Mockito.when(mockOrderEntityToOrderSummaryTransformation.transform(orderEntity)).thenReturn(orderSummary);
		//Execution
		List<OrderSummary> orderSummaryList = target.getOrderSummary(CUSTOMER_ID);
		
		//Verification
		Mockito.verify(mockOrderDao).findOrdersByCustomer(CUSTOMER_ID);
		Mockito.verify(mockOrderEntityToOrderSummaryTransformation).transform(orderEntity);
		Assert.assertNotNull(orderSummaryList);
		Assert.assertEquals(1, orderSummaryList.size());
		Assert.assertSame(orderSummary, orderSummaryList.get(0));
	}
}
