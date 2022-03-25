package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.OrderDao;
import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.model.entity.Order;
import com.amr.project.service.abstracts.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends ReadWriteServiceImpl<Order, Long> implements OrderService {
    private final OrderDao orderDao;

    public OrderServiceImpl(ReadWriteDao<Order, Long> dao, OrderDao orderDao) {
        super(dao);
        this.orderDao = orderDao;
    }

    @Override
    public List<Order> findOrdersByUser(Long id) {
        return orderDao.findOrdersByUser(id);
    }
}
