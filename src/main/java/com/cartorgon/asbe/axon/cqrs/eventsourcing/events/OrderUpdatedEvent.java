package com.cartorgon.asbe.axon.cqrs.eventsourcing.events;

import com.cartorgon.asbe.axon.AxonOrderComponent;
import com.cartorgon.asbe.model.impl.OrderEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class OrderUpdatedEvent implements AxonOrderComponent {
	
	private OrderEntity order;

	@Override
	public final long orderId() {
		return this.order== null ? 0 : this.order.getId();
	}

	@Override
	public final String product() {
		return this.order.getProduct();
	}
}