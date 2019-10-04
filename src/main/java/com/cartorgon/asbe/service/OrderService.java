package com.cartorgon.asbe.service;

import java.util.List;

import com.cartorgon.asbe.model.impl.OrderDto;

public interface OrderService {
	List<OrderDto> getOrders();
	OrderDto updateOrder(OrderDto order);
}