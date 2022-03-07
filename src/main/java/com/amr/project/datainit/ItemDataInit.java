package com.amr.project.datainit;

import com.amr.project.dao.abstracts.CategoryDao;
import com.amr.project.dao.abstracts.ItemDao;
import com.amr.project.dao.abstracts.ReviewDao;
import com.amr.project.model.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
public class ItemDataInit {

    private final ItemDao itemDao;
    private final CategoryDao categoryDao;
    private final ReviewDao reviewDao;

    @Autowired
    private ItemDataInit(ItemDao itemDao, CategoryDao categoryDao, ReviewDao reviewDao) {
        this.itemDao = itemDao;
        this.categoryDao = categoryDao;
        this.reviewDao = reviewDao;
    }

    @PostConstruct
    private void itemDataInit() {
        itemDao.persist(Item.builder().name("White Wooden Table")
                .basePrice(BigDecimal.valueOf(150)).price(BigDecimal.valueOf(125.6))
                .count(19).rating(4)
                .description("The best of the best").discount(5)
                .isModerated(true).moderatedRejectReason("adding")
                .categories(Set.of(categoryDao.findById(3L)))
                .reviews(List.of(reviewDao.findById(1L)))
                .build());

        itemDao.persist(Item.builder().name("Black Wooden Table")
                .basePrice(BigDecimal.valueOf(250)).price(BigDecimal.valueOf(225.3))
                .count(3).rating(4.95)
                .description("You realy looked only for this!").discount(10)
                .isModerated(true).moderatedRejectReason("adding")
                .categories(Set.of(categoryDao.findById(3L)))
                .reviews(List.of(reviewDao.findById(2L), reviewDao.findById(3L))).build());

        itemDao.persist(Item.builder().name("IPhone 15R")
                .basePrice(BigDecimal.valueOf(400)).price(BigDecimal.valueOf(350.6))
                .count(10).rating(4.0)
                .description("Final version").discount(1)
                .isModerated(true).moderatedRejectReason("adding")
                .categories(Set.of(categoryDao.findById(2L)))
                .reviews(List.of(reviewDao.findById(4L))).build());

        itemDao.persist(Item.builder().name("Nokia 3310")
                .basePrice(BigDecimal.valueOf(212)).price(BigDecimal.valueOf(200))
                .count(2).rating(5)
                .description("The oldest phone in whole world").discount(66)
                .isModerated(true).moderatedRejectReason("adding")
                .categories(Set.of(categoryDao.findById(2L)))
                .reviews(List.of(reviewDao.findById(5L))).build());

        itemDao.persist(Item.builder().name("Adult Bicycle")
                .basePrice(BigDecimal.valueOf(180)).price(BigDecimal.valueOf(176.1))
                .count(1).rating(4.62)
                .description("Its only bicycle").discount(25)
                .isModerated(true).moderatedRejectReason("adding")
                .categories(Set.of(categoryDao.findById(1L)))
                .reviews(List.of(reviewDao.findById(6L))).build());

        itemDao.persist(Item.builder().name("Child Pink Bicycle")
                .basePrice(BigDecimal.valueOf(150)).price(BigDecimal.valueOf(130))
                .count(6).rating(4.12)
                .description("Pink for really honeys").discount(25)
                .isModerated(true).moderatedRejectReason("adding")
                .categories(Set.of(categoryDao.findById(1L)))
                .reviews(List.of(reviewDao.findById(7L), reviewDao.findById(10L))).build());

        itemDao.persist(Item.builder().name("Swedish Chairs")
                .basePrice(BigDecimal.valueOf(210.09))
                .price(BigDecimal.valueOf(200.55))
                .description("I know? you want their").discount(0)
                .isModerated(true).moderatedRejectReason("adding")
                .categories(Set.of(categoryDao.findById(4L)))
                .count(20).rating(5.0)
                .reviews(List.of(reviewDao.findById(8L))).build());

        itemDao.persist(Item.builder().name("Chairs for Children")
                .basePrice(BigDecimal.valueOf(188.23))
                .price(BigDecimal.valueOf(180))
                .count(40).rating(4.99)
                .description("For little brothers and sisters").discount(33)
                .isModerated(true).moderatedRejectReason("adding")
                .categories(Set.of(categoryDao.findById(4L)))
                .reviews(List.of(reviewDao.findById(9L), reviewDao.findById(11L))).build());
    }
}
