package com.cartorgon.asbe.service;

import java.util.List;

import com.cartorgon.asbe.model.impl.OrderEntity;

public interface OrderService {
	List<OrderEntity> getOrders();
	OrderEntity updateOrder(OrderEntity order);
}