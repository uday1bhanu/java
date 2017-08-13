package com.uday.order.integration;

import com.uday.order.model.message.OrderMessage;

public class WarehouseManagementService {

	public static boolean sendOrder(OrderMessage orderMessage) throws WMSUnavailableException {
		throw new WMSUnavailableException("WMS is currently down for unknown reason");
	}
}
