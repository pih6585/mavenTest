package com.test.jpa.mavenTest.repository;

import com.test.jpa.mavenTest.entity.OrderItem;
import com.test.jpa.mavenTest.repository.query.OrderItemRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>, OrderItemRepositoryQuery {
}
