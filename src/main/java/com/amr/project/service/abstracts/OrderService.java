package com.amr.project.service.abstracts;

import com.amr.project.model.entity.Order;

import java.util.List;

public interface OrderService extends ReadWriteService<Order, Long> {
    List<Order> findOrdersByUser(Long id);
}
