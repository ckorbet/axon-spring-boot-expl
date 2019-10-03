package com.cartorgon.asbe.mode.impl;

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
}