package com.cartorgon.asbe.model.impl;

import com.cartorgon.asbe.model.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class OrderDto implements Order {
	private long id;
	private String product;
	
	/**
	 * <p>
	 * Given an {@link OrderEntity}, returns it corresponding Dto
	 * </p>
	 * @param order
	 * @return
	 */
	public static final OrderDto fromEntityToDto(final OrderEntity order) {
		return new OrderDto(order.getId(), order.getProduct());
	}
}