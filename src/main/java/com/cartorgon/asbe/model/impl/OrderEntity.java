package com.cartorgon.asbe.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import com.cartorgon.asbe.model.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDERS")
@Validated
@Data @AllArgsConstructor @NoArgsConstructor
public class OrderEntity implements Order {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String product;
	
	/**
	 * <p>
	 * Given an {@link OrderDto}, return its corresponding Entity
	 * </p>
	 * @param order
	 * @return
	 */
	public static final OrderEntity fromDtoToEntity(final OrderDto order) {
		return new OrderEntity(order.getId(), order.getProduct());
	}
}