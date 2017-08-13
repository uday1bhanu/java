package com.uday.order.model.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.uday.common.DataAccessException;
import com.uday.common.ServiceException;
import com.uday.order.dao.OrderDao;
import com.uday.order.model.domain.OrderSummary;
import com.uday.order.model.entity.OrderEntity;
import com.uday.order.model.transformation.OrderEntityToOrderSummaryTransformation;

import junit.framework.Assert;

public class OrderServiceImplTestWithMocktioAnnotations {
	private final static long CUSTOMER_ID = 1L;
	
	private @Mock OrderDao mockOrderDao;
	private @Mock OrderEntityToOrderSummaryTransformation mockOrderEntityToOrderSummaryTransformation;
	private OrderServiceImpl target = new OrderServiceImpl();
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		target.setOrderDao(mockOrderDao);
		target.setOrderEntityToOrderSummaryTransformation(mockOrderEntityToOrderSummaryTransformation);
	}
	
	@Test
	public void test_getOrderSummary_success() throws ServiceException, DataAccessException{
		//Setup
		//OrderServiceImpl target = new OrderServiceImpl();
		
		//OrderDao mockOrderDao = Mockito.mock(OrderDao.class);
		//target.setOrderDao(mockOrderDao);
		
		//OrderEntityToOrderSummaryTransformation mockOrderEntityToOrderSummaryTransformation = Mockito.mock(OrderEntityToOrderSummaryTransformation.class);
		//target.setOrderEntityToOrderSummaryTransformation(mockOrderEntityToOrderSummaryTransformation);
		
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
	
	@Test
	public void test_openNewOrder_successfullyRetriesDataInsert() throws Exception{
		//Setup
		Mockito.when(mockOrderDao.insert(Mockito.any(OrderEntity.class)))
		.thenThrow(new DataAccessException("First Ex")).thenReturn(1);
		
		//Execution
		target.openNewOrder(CUSTOMER_ID);
		
		//Verification
		Mockito.verify(mockOrderDao, Mockito.times(2)).insert(Mockito.any(OrderEntity.class));
	}
	
	@Test(expected=ServiceException.class)
	public void test_openNewOrder_failedDataInsert() throws Exception {
		//Setup
		Mockito.when(mockOrderDao.insert(Mockito.any(OrderEntity.class)))
		.thenThrow(new DataAccessException("First Ex"))
		.thenThrow(new DataAccessException("Second Ex"));
		
		//Execution
		try{
			target.openNewOrder(CUSTOMER_ID);
		}
		finally{
			//Verification
			Mockito.verify(mockOrderDao, Mockito.times(3))
			.insert(Mockito.any(OrderEntity.class));
		}
	}
	
	@Test
	public void test_openNewOrder_success() throws DataAccessException, ServiceException{
		//Setup
		Mockito.when(mockOrderDao.insert(Mockito.any(OrderEntity.class)))
		.thenReturn(1);
		
		//Execution
		String orderNumber = target.openNewOrder(CUSTOMER_ID);
		
		//Verification
		ArgumentCaptor<OrderEntity> orderEntityCaptor = ArgumentCaptor.forClass(OrderEntity.class);
		Mockito.verify(mockOrderDao).insert(orderEntityCaptor.capture());
		
		assertNotNull(orderEntityCaptor);
		assertEquals(CUSTOMER_ID, orderEntityCaptor.getValue().getCustomerId());
		assertEquals(orderNumber, orderEntityCaptor.getValue().getOrderNumber());
	}
}
