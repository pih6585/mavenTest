package com.test.jpa.mavenTest.repository;

import com.test.jpa.mavenTest.entity.Order;
import com.test.jpa.mavenTest.repository.query.OrderRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>, OrderRepositoryQuery {

}
