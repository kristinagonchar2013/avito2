package com.amr.project.converter;

import com.amr.project.model.dto.OrderDto;
import com.amr.project.model.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order orderDtoToOrder(OrderDto orderDto);

    OrderDto orderToOrderDto(Order order);

    List<Order> allOrdersDtoToOrders(List<OrderDto> orderDtoList);

    List<OrderDto> allOrdersToOrderDtos(List<Order> orderList);
}
