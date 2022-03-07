package com.amr.project.datainit;

import com.amr.project.dao.abstracts.DiscountDao;
import com.amr.project.model.entity.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DiscountDataInit {

    private final DiscountDao dao;

    @Autowired
    private DiscountDataInit(DiscountDao dao) {
        this.dao = dao;
    }

    @PostConstruct
    private void discountDataInit() {
        dao.persist(Discount.builder().minOrder(150).percentage(5).build());
        dao.persist(Discount.builder().minOrder(350).percentage(15).build());
        dao.persist(Discount.builder().minOrder(220).percentage(10).build());
        dao.persist(Discount.builder().minOrder(380).percentage(25).build());
    }
}
