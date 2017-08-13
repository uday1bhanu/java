package com.uday.order.model.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.uday.common.DataAccessException;
import com.uday.common.ServiceException;
import com.uday.order.dao.OrderDao;
import com.uday.order.integration.WMSUnavailableException;
import com.uday.order.integration.WarehouseManagementService;
import com.uday.order.model.domain.OrderCompletionAudit;
import com.uday.order.model.entity.OrderEntity;
import com.uday.order.model.entity.OrderItemEntity;
import com.uday.order.model.message.OrderMessage;
import com.uday.order.model.transformation.OrderEntityToOrderSummaryTransformation;

@RunWith(PowerMockRunner.class)
@PrepareForTest(value={WarehouseManagementService.class, OrderServiceImpl.class})
public class OrderServiceImplTestWithPowerMock {
	private final static long CUSTOMER_ID = 1;
	private final static long ORDER_ID = 2;
	private final static String ORDER_NUMBER = "1234";
	
	private OrderServiceImpl target = null;
	
	protected @Mock OrderDao mockOrderDao;
	protected @Mock OrderEntityToOrderSummaryTransformation mockOrderEntityToOrderSummaryTransformation;
	
	@Before()
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		target = new OrderServiceImpl();
		target.setOrderDao(mockOrderDao);
		target.setOrderEntityToOrderSummaryTransformation(mockOrderEntityToOrderSummaryTransformation);
	}
	
	@Test
	public void test_completeOrder_success() throws Exception{
		//Setup
		OrderItemEntity oiFixture1 = new OrderItemEntity();
		oiFixture1.setSku("SKU1");
		oiFixture1.setQuantity(1);
		
		OrderItemEntity oiFixture2 = new OrderItemEntity();
		oiFixture2.setSku("SKU2");
		oiFixture2.setQuantity(2);
		
		OrderEntity oeFixture = new OrderEntity();
		oeFixture.setOrderNumber(ORDER_NUMBER);
		oeFixture.setOrderItemList(new LinkedList<OrderItemEntity>());
		oeFixture.getOrderItemList().add(oiFixture1);
		oeFixture.getOrderItemList().add(oiFixture2);
		
		Mockito.when(mockOrderDao.findById(ORDER_ID)).thenReturn(oeFixture);
		
		//add static mocking
		PowerMockito.mockStatic(WarehouseManagementService.class);
		PowerMockito.when(WarehouseManagementService.sendOrder(Mockito.any(OrderMessage.class)))
		.thenReturn(true);
		
		OrderCompletionAudit orderCompletionAuditFixture = new OrderCompletionAudit();
		PowerMockito.whenNew(OrderCompletionAudit.class).withNoArguments()
		.thenReturn(orderCompletionAuditFixture);
		
		//Execution
		target.completeOrder(ORDER_ID);
		
		//Verification
		 Mockito.verify(mockOrderDao, Mockito.times(1)).findById(ORDER_ID);
		PowerMockito.verifyStatic();
		
		ArgumentCaptor<OrderMessage> argumentCaptorCapture = ArgumentCaptor.forClass(OrderMessage.class);
		WarehouseManagementService.sendOrder(argumentCaptorCapture.capture());
		OrderMessage orderMessageCapture = argumentCaptorCapture.getValue();
		
		assertNotNull(orderMessageCapture);
		assertEquals(ORDER_NUMBER, orderMessageCapture.getOrderNumber());
		
		assertEquals(ORDER_NUMBER, orderCompletionAuditFixture.getOrderNumber());
		assertNotNull(orderCompletionAuditFixture);
	}
}
