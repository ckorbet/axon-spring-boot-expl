package com.cartorgon.asbe.axon.cqrs.queries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import com.cartorgon.asbe.axon.cqrs.eventsourcing.events.OrderUpdatedEvent;
import com.cartorgon.asbe.model.impl.OrderDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Data @AllArgsConstructor @NoArgsConstructor
public class GetAllOrdersQueryEventHandler {
	
	private Map<Long, OrderDto> orders = new HashMap<>();
	
	@EventHandler
	public final void on(final OrderUpdatedEvent event) {
		log.info("I'm in get all orders query event handler");
		this.orders.put(event.getOrder().getId(), event.getOrder());
	}
	
	@QueryHandler
	public final List<OrderDto> handle(GetAllOrdersQuery query) {
		log.info("I'm in get all orders query handler");
		return new ArrayList<>(this.orders.values());
	}
}