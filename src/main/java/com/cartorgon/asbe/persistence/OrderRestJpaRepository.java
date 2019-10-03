package com.cartorgon.asbe.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cartorgon.asbe.model.impl.OrderEntity;

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrderRestJpaRepository extends JpaRepository<OrderEntity, Long>{

}