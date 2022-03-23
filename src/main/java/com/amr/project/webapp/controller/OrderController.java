package com.amr.project.webapp.controller;

import com.amr.project.converter.OrderMapper;
import com.amr.project.model.dto.OrderDto;
import com.amr.project.model.entity.Order;
import com.amr.project.service.abstracts.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable Long id) {
        orderService.delete(orderService.findById(id));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(orderMapper.allOrdersToOrderDtos(orderService.findAll()));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<OrderDto>> getOrdersByUser(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(orderMapper.allOrdersToOrderDtos(orderService.findOrdersByUser(id)));
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(orderMapper.orderToOrderDto(orderService.findById(id)));
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long id, @Valid @RequestBody OrderDto orderDto) {
        Order order = orderMapper.orderDtoToOrder(orderDto);
        order.setId(id);
        orderService.update(order);
        return ResponseEntity.status(HttpStatus.OK).body(orderDto);
    }

    @PostMapping("")
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody OrderDto orderDto) {
        orderService.persist(orderMapper.orderDtoToOrder(orderDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
    }
}
