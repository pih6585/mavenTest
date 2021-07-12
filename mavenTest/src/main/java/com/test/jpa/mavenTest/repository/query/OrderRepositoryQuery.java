package com.test.jpa.mavenTest.repository.query;

import com.test.jpa.mavenTest.dto.OrderDto;

import java.util.List;

public interface OrderRepositoryQuery {

    //전체 조인 - 전체
    List<OrderDto> findAllByInItemDto(OrderDto orderDto);

    //제품조인 - 제외 - 전체
    List<OrderDto> findByAllByNotInItemDto(OrderDto orderDto);

}
