package com.amr.project.dao.datainit;

import com.amr.project.dao.abstracts.DiscountDao;
import com.amr.project.model.entity.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DiscountDataInit {

    private final DiscountDao dao;

    @Autowired
    public DiscountDataInit(DiscountDao dao) {
        this.dao = dao;
    }

    @PostConstruct
    public void discountDataInit() {
        dao.persist(Discount.builder().id(1L).minOrder(150).percentage(5).build());
        dao.persist(Discount.builder().id(2L).minOrder(350).percentage(15).build());
        dao.persist(Discount.builder().id(3L).minOrder(220).percentage(10).build());
        dao.persist(Discount.builder().id(4L).minOrder(380).percentage(25).build());
    }
}
