package com.amr.project.webapp.config.datainit;

import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.model.entity.Category;
import com.amr.project.model.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
public class ItemDataInit {

    private final ReadWriteDao<Item, Long> itemReadWriteDao;
    private final ReadWriteDao<Category, Long> categoryDao;

    @Autowired
    public ItemDataInit(ReadWriteDao<Item, Long> itemReadWriteDao, ReadWriteDao<Category, Long> categoryDao) {
        this.itemReadWriteDao = itemReadWriteDao;
        this.categoryDao = categoryDao;
    }

    @PostConstruct
    public void itemDataInit() {
        itemReadWriteDao.persist(Item.builder().id(1L).name("White Wooden Table").basePrice(BigDecimal.valueOf(150))
                .price(BigDecimal.valueOf(125.6)).category(categoryDao.findById(3L)).count(19).rating(4.7).isModerated(true)
                .build());
        itemReadWriteDao.persist(Item.builder().id(2L).name("Black Wooden Table").basePrice(BigDecimal.valueOf(250))
                .price(BigDecimal.valueOf(225.3)).category(categoryDao.findById(3L)).count(3).rating(4.95).isModerated(true)
                .build());
        itemReadWriteDao.persist(Item.builder().id(3L).name("IPhone 15R").basePrice(BigDecimal.valueOf(400))
                .price(BigDecimal.valueOf(350.6)).category(categoryDao.findById(2L)).count(10).rating(4.0).isModerated(true)
                .build());
        itemReadWriteDao.persist(Item.builder().id(4L).name("Nokia 3310").basePrice(BigDecimal.valueOf(212))
                .price(BigDecimal.valueOf(200)).category(categoryDao.findById(2L)).count(2).rating(5).isModerated(true)
                .build());
        itemReadWriteDao.persist(Item.builder().id(5L).name("Adult Bicycle").basePrice(BigDecimal.valueOf(180))
                .price(BigDecimal.valueOf(176.1)).category(categoryDao.findById(1L)).count(1).rating(4.62).isModerated(true)
                .build());
        itemReadWriteDao.persist(Item.builder().id(6L).name("Child Pink Bicycle").basePrice(BigDecimal.valueOf(150))
                .price(BigDecimal.valueOf(130)).category(categoryDao.findById(1L)).count(6).rating(4.12).isModerated(true)
                .build());
        itemReadWriteDao.persist(Item.builder().id(7L).name("Swedish Chairs").basePrice(BigDecimal.valueOf(210.09))
                .price(BigDecimal.valueOf(200.55)).category(categoryDao.findById(4L)).count(20).rating(5.0).isModerated(true)
                .build());
        itemReadWriteDao.persist(Item.builder().id(8L).name("Chairs for Children").basePrice(BigDecimal.valueOf(188.23))
                .price(BigDecimal.valueOf(180)).category(categoryDao.findById(4L)).count(40).rating(4.99).isModerated(true)
                .build());
    }
}
