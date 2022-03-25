package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.OrderDao;
import com.amr.project.model.entity.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OrderDaoImpl extends ReadWriteDaoImpl<Order, Long> implements OrderDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Order> findOrdersByUser(Long id) {
        return em.createQuery("SELECT o FROM Order o WHERE o.user.id = :id", Order.class)
                .setParameter("id", id)
                .getResultList();
    }
}
