package com.amr.project.dao.datainit;

import com.amr.project.dao.abstracts.CategoryDao;
import com.amr.project.dao.abstracts.ItemDao;
import com.amr.project.dao.abstracts.ReviewDao;
import com.amr.project.model.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class ItemDataInit {

    private final ItemDao itemDao;
    private final CategoryDao categoryDao;
    private final ReviewDao reviewDao;

    @Autowired
    public ItemDataInit(ItemDao itemDao, CategoryDao categoryDao, ReviewDao reviewDao) {
        this.itemDao = itemDao;
        this.categoryDao = categoryDao;
        this.reviewDao = reviewDao;
    }

    @PostConstruct
    public void itemDataInit() {
        itemDao.persist(Item.builder().id(1L).name("White Wooden Table").basePrice(BigDecimal.valueOf(150))
                .price(BigDecimal.valueOf(125.6)).category(categoryDao.findById(3L)).count(19).isModerated(true)
                .rating(4).reviews(Arrays.asList(reviewDao.findById(1L))).build());
        itemDao.persist(Item.builder().id(2L).name("Black Wooden Table").basePrice(BigDecimal.valueOf(250))
                .price(BigDecimal.valueOf(225.3)).category(categoryDao.findById(3L)).count(3).isModerated(true)
                .rating(4.95).reviews(Arrays.asList(reviewDao.findById(2L), reviewDao.findById(3L))).build());
        itemDao.persist(Item.builder().id(3L).name("IPhone 15R").basePrice(BigDecimal.valueOf(400))
                .price(BigDecimal.valueOf(350.6)).category(categoryDao.findById(2L)).count(10).isModerated(true)
                .rating(4.0).reviews(Arrays.asList(reviewDao.findById(4L))).build());
        itemDao.persist(Item.builder().id(4L).name("Nokia 3310").basePrice(BigDecimal.valueOf(212))
                .price(BigDecimal.valueOf(200)).category(categoryDao.findById(2L)).count(2).rating(5).isModerated(true)
                .reviews(Arrays.asList(reviewDao.findById(5L))).build());
        itemDao.persist(Item.builder().id(5L).name("Adult Bicycle").basePrice(BigDecimal.valueOf(180))
                .price(BigDecimal.valueOf(176.1)).category(categoryDao.findById(1L)).count(1).rating(4.62)
                .isModerated(true).reviews(Arrays.asList(reviewDao.findById(6L))).build());
        itemDao.persist(Item.builder().id(6L).name("Child Pink Bicycle").basePrice(BigDecimal.valueOf(150))
                .price(BigDecimal.valueOf(130)).category(categoryDao.findById(1L)).count(6).rating(4.12)
                .isModerated(true).reviews(Arrays.asList(reviewDao.findById(7L), reviewDao.findById(10L))).build());
        itemDao.persist(Item.builder().id(7L).name("Swedish Chairs").basePrice(BigDecimal.valueOf(210.09))
                .price(BigDecimal.valueOf(200.55)).category(categoryDao.findById(4L)).count(20).rating(5.0)
                .isModerated(true).reviews(Arrays.asList(reviewDao.findById(8L))).build());
        itemDao.persist(Item.builder().id(8L).name("Chairs for Children").basePrice(BigDecimal.valueOf(188.23))
                .price(BigDecimal.valueOf(180)).category(categoryDao.findById(4L)).count(40).rating(4.99)
                .isModerated(true).reviews(Arrays.asList(reviewDao.findById(9L), reviewDao.findById(11L))).build());
    }
}
