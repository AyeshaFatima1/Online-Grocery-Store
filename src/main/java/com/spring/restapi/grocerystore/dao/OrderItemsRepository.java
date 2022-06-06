package com.spring.restapi.grocerystore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.restapi.grocerystore.model.OrderItem;

public interface OrderItemsRepository extends JpaRepository<OrderItem,Integer> {
}
