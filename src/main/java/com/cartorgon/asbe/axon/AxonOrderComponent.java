package com.cartorgon.asbe.axon;

import com.cartorgon.asbe.model.impl.OrderEntity;

/**
 * <p>
 * Base class for the {@link OrderEntity} commands
 * </p>
 */
public interface AxonOrderComponent {
	long orderId();
	String product();
}