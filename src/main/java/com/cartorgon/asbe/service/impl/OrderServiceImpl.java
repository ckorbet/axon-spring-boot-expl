package com.cartorgon.asbe.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartorgon.asbe.axon.cqrs.commands.OrderUpdateCommand;
import com.cartorgon.asbe.axon.cqrs.queries.GetAllOrdersQuery;
import com.cartorgon.asbe.model.impl.OrderDto;
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
	public final List<OrderDto> getOrders() {
		log.info("Retrieving list of orders...");
		/*
		 * Since we're using Axon CQRS,
		 * we don't return entities directly from repo,
		 * but from the queryGtw
		 * final List<OrderEntity> retrieved = this.repo.findAll();
		 */		
		final List<OrderDto> resList = 
				this.queryGtw.query(new GetAllOrdersQuery(), ResponseTypes.multipleInstancesOf(OrderDto.class)).join();
		if(resList.isEmpty()) {
			log.warn("No order retrieved");
		} else {
			log.info("Returning orders");
		}		
		return resList;
	}

	@Override
	public final OrderDto updateOrder(final OrderDto order) {
		if(order.getId() == 0l) {
			throw new IllegalArgumentException("The Id of order to be updated cannot be null, blank, or empty");
		}
		log.info("Updating order...");
		final OrderEntity updated = this.repo.save(OrderEntity.fromDtoToEntity(order));
		OrderDto res = null;
		if(updated.getId() == order.getId()) {
			commandGtw.send(new OrderUpdateCommand(order));
			res = OrderDto.fromEntityToDto(updated);
			log.info("Order correctly updated");			
		} else {
			log.warn("Something went wrong. Order NOT updated");
		}
		return res;
	}
}