package com.test.jpa.mavenTest.repository.query;

import com.test.jpa.mavenTest.dto.OrderItemDto;

import java.util.List;

public interface OrderItemRepositoryQuery {
    List<OrderItemDto> findByOrderItemDto(List<Long> orderIds);
}
