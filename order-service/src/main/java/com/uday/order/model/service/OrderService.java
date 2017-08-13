package com.uday.order.model.service;

import java.util.List;

import com.uday.common.ServiceException;
import com.uday.order.model.domain.OrderSummary;

public interface OrderService {
	List<OrderSummary> getOrderSummary(long customerId) throws ServiceException;
}
