package com.cartorgon.asbe.rest.impl;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cartorgon.asbe.model.impl.OrderDto;
import com.cartorgon.asbe.rest.AxonOrderRest;
import com.cartorgon.asbe.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AxonOrderRestImpl implements AxonOrderRest {
	
	@Autowired
	private OrderService service;

	@Override
	@GetMapping(path = "/getorders", produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<List<OrderDto>> getOrders() {
		log.info("Received request to 'getOrders()'...");
		final List<OrderDto> resList = this.service.getOrders();
		log.info("Serving response");
		return new ResponseEntity<>(resList, HttpStatus.OK);
	}

	@Override
	@PostMapping(path = "/updateorder", produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<OrderDto> updateOrder(@RequestBody @NotNull final OrderDto order) {
		if(order.getId() == 0l) {
			throw new IllegalArgumentException("The Id of order to be updated cannot be null, blank, or empty");
		}
		log.info("Received request to 'updateOrder()'...");
		final OrderDto resOrder = this.service.updateOrder(order); 
		log.info("Serving response");
		return new ResponseEntity<>(resOrder, HttpStatus.OK);
	}
}