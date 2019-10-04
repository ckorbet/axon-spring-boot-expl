package com.cartorgon.asbe.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cartorgon.asbe.model.impl.OrderDto;

public interface AxonOrderRest {
	ResponseEntity<List<OrderDto>> getOrders();
	ResponseEntity<OrderDto> updateOrder(OrderDto order);
}