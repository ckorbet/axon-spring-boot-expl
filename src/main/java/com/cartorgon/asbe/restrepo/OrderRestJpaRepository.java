package com.cartorgon.asbe.restrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cartorgon.asbe.mode.impl.OrderEntity;

@RepositoryRestResource(collectionResourceRel = "beverages", path = "beverages")
public interface OrderRestJpaRepository extends JpaRepository<OrderEntity, Long>{

}