package com.spring.restapi.grocerystore.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.restapi.grocerystore.model.Order;
import com.spring.restapi.grocerystore.model.User;

import java.util.List;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Integer> {
	
    List<Order> findAllByUserOrderByCreatedDateDesc(User user);

}
