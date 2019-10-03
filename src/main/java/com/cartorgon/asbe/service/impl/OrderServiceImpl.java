package com.cartorgon.asbe.service.impl;

import java.util.List;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartorgon.asbe.axon.cqrs.commands.OrderUpdateCommand;
import com.cartorgon.asbe.model.impl.OrderEntity;
import com.cartorgon.asbe.persistence.OrderRestJpaRepository;
import com.cartorgon.asbe.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRestJpaRepository repo;
	
	@Autowired
	private CommandGateway commandGtw;
	
	@Autowired
	private QueryGateway queryGtw;

	@Override
	public final List<OrderEntity> getOrders() {
		log.info("Retrieving list of orders...");
		final List<OrderEntity> resList = this.repo.findAll();
		if(resList == null || resList.isEmpty()) {
			log.warn("No order retrieved");
		} else {
			log.info("Returning orders");
		}		
		return resList;
	}

	@Override
	public final OrderEntity updateOrder(final OrderEntity order) {
		if(order.getId() == 0l) {
			throw new IllegalArgumentException("The Id of order to be updated cannot be null, blank, or empty");
		}
		log.info("Updating order...");
		final OrderEntity updated = this.repo.save(order);
		if(updated.getId() == order.getId()) {
			commandGtw.send(new OrderUpdateCommand(updated));
			log.info("Order correctly updated");			
		}
		return updated;
	}
}