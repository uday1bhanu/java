package com.uday.order.model.transaformation;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.uday.order.model.domain.OrderSummary;
import com.uday.order.model.entity.OrderEntity;
import com.uday.order.model.entity.OrderItemEntity;
import com.uday.order.model.transformation.OrderEntityToOrderSummaryTransformation;

public class OrderEntityToOrderSummaryTransformationTest {

	private OrderEntityToOrderSummaryTransformation target = null;
	
	@Before
	public void setUp(){
		target = new OrderEntityToOrderSummaryTransformation();
	}
	
	@Test
	public void test_transform_success(){
		String orderNumberFixture = UUID.randomUUID().toString();
		
		OrderEntity orderEntityFixture = new OrderEntity();
		orderEntityFixture.setOrderNumber(orderNumberFixture);
		orderEntityFixture.setOrderItemList(new LinkedList<OrderItemEntity>());
		
		OrderItemEntity orderItemEntityFixture1 = new OrderItemEntity();
		orderItemEntityFixture1.setQuantity(1);
		orderItemEntityFixture1.setSellingPrice(BigDecimal.valueOf(10.00));
		orderEntityFixture.getOrderItemList().add(orderItemEntityFixture1);
		
		OrderItemEntity orderItemEntityFixture2 = new OrderItemEntity();
		orderItemEntityFixture2.setQuantity(2);
		orderItemEntityFixture2.setSellingPrice(BigDecimal.valueOf(1.50));
		orderEntityFixture.getOrderItemList().add(orderItemEntityFixture2);
		
		OrderSummary result = target.transform(orderEntityFixture); 
		
		Assert.assertNotNull(result);
		Assert.assertEquals(orderNumberFixture, result.getOrderNumber());
		Assert.assertEquals(3, result.getItemCount());
		Assert.assertEquals(BigDecimal.valueOf(13.00), result.getTotalAmount());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_tranform_inputIsNull(){
		target.transform(null);
	}
	
	@Test
	public void test_transform_noItems(){
		String orderNumberFixture = UUID.randomUUID().toString();
		
		OrderEntity orderEntityFixture = new OrderEntity();
		orderEntityFixture.setOrderNumber(orderNumberFixture);
		
		OrderSummary result = target.transform(orderEntityFixture);
		
		Assert.assertNotNull(result);
		Assert.assertEquals(0, result.getItemCount());
		Assert.assertEquals(BigDecimal.valueOf(0.00), result.getTotalAmount());
	}
}
