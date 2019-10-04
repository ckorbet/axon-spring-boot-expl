package com.cartorgon.asbe.axon.cqrs.commands.model;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import com.cartorgon.asbe.axon.AxonOrderComponent;
import com.cartorgon.asbe.axon.cqrs.commands.OrderUpdateCommand;
import com.cartorgon.asbe.axon.cqrs.eventsourcing.events.OrderUpdatedEvent;
import com.cartorgon.asbe.model.impl.OrderDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Aggregate
@Slf4j
@Data @AllArgsConstructor @NoArgsConstructor
public class OrderAggregate implements AxonOrderComponent {

	private OrderDto order;

	@Override
	@TargetAggregateIdentifier
	public final long orderId() {
		return this.order == null ? 0 : this.order.getId();
	}

	@Override
	public final String product() {
		return this.order.getProduct();
	}	
	
	@CommandHandler
	public OrderAggregate(final OrderUpdateCommand command) {
		log.info("I'm in the order update command handler");
		AggregateLifecycle.apply(new OrderUpdatedEvent(command.getOrder()));
	}
	
	@EventSourcingHandler
	public final void on(final OrderUpdatedEvent event) {
		log.info("I'm in the order event source handler");
		this.order = event.getOrder();
	}
}