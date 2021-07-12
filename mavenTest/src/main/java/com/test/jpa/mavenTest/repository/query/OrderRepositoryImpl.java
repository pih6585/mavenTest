package com.test.jpa.mavenTest.repository.query;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.jpa.mavenTest.dto.OrderDto;
import com.test.jpa.mavenTest.dto.QOrderDto;
import com.test.jpa.mavenTest.enumClass.OrderStatus;

import javax.persistence.EntityManager;
import java.util.List;

import static com.test.jpa.mavenTest.entity.QDelivery.delivery;
import static com.test.jpa.mavenTest.entity.QMember.member;
import static com.test.jpa.mavenTest.entity.QOrder.order;
import static com.test.jpa.mavenTest.entity.QOrderItem.orderItem;

public class OrderRepositoryImpl implements OrderRepositoryQuery{

    private final EntityManager em;

    private final JPAQueryFactory queryFactory;

    public OrderRepositoryImpl(EntityManager em) {
        this.em = em;
        queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public List<OrderDto> findAllByInItemDto(OrderDto orderDto) {
        List<OrderDto> orderDtoList = queryFactory
                .select(new QOrderDto(order.id,
                        member.username,
                        delivery.address.city, delivery.address.street, delivery.address.zipcode,
                        orderItem.item.name, orderItem.orderPrice, orderItem.count, order.orderDate, order.status, delivery.status
                ))
                .from(order)
                .join(order.member, member)
                .join(order.delivery, delivery)
                .join(order.orderItems, orderItem)
                .where(memberNameEq(orderDto.getUsername()),orderStatusEq(orderDto.getOrderStatus()))
                .fetch();
        return orderDtoList;
    }


    @Override
    public List<OrderDto> findByAllByNotInItemDto(OrderDto orderDto) {
        List<OrderDto> orderDtoList = queryFactory
                .select(new QOrderDto(order.id,
                        member.username,
                        delivery.address.city, delivery.address.street, delivery.address.zipcode,
                        order.orderDate, order.status, delivery.status
                ))
                .from(order)
                .join(order.member, member)
                .join(order.delivery, delivery)
                .where(memberNameEq(orderDto.getUsername()),orderStatusEq(orderDto.getOrderStatus()))
                .fetch();
        return orderDtoList;
    }

    private BooleanExpression orderStatusEq(OrderStatus orderStatus) {
        return orderStatus == null ? null : order.status.eq(orderStatus);
    }

    private BooleanExpression memberNameEq(String username) {
        return username == null ? null : username.equals("") ? null : order.member.username.eq(username);
    }
}
