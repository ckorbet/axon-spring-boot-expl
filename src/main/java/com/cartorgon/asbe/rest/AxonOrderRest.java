package com.cartorgon.asbe.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cartorgon.asbe.model.impl.OrderEntity;

public interface AxonOrderRest {
	ResponseEntity<List<OrderEntity>> getOrders();
	ResponseEntity<OrderEntity> updateOrder(OrderEntity order);
}