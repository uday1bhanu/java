package com.uday.order.dao;

import java.util.List;

import com.uday.common.DataAccessException;
import com.uday.order.model.entity.OrderEntity;

public interface OrderDao {

	OrderEntity findById(long id) throws DataAccessException;
	int insert(OrderEntity order) throws DataAccessException;
	
	List<OrderEntity> findOrdersByCustomer(long customerId) throws DataAccessException;
}