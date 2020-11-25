package com.order.management.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.order.management.orderservice.model.OrderDetails;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails,Integer> {
	
	}
