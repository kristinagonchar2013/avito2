package com.amr.project.webapp.config.datainit;

import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.model.entity.Country;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class ShopDataInit {

    private final ReadWriteDao<Shop, Long> shopReadWriteDao;
    private final ReadWriteDao<Country, Long> countryReadWriteDao;
    private final ReadWriteDao<Item, Long> itemReadWriteDao;

    @Autowired
    public ShopDataInit(ReadWriteDao<Shop, Long> shopReadWriteDao, ReadWriteDao<Country, Long> countryReadWriteDao
    , ReadWriteDao<Item, Long> itemReadWriteDao) {
        this.shopReadWriteDao = shopReadWriteDao;
        this.countryReadWriteDao = countryReadWriteDao;
        this.itemReadWriteDao = itemReadWriteDao;
    }

    @PostConstruct
    public void shopDataInit() {
        shopReadWriteDao.persist(Shop.builder().id(1L).name("Chairs & Co").location(countryReadWriteDao.findById(1L))
                .email("chairs.co@gmail.com").phone("11111111").rating(4.44).isModerated(true)
                .items(Arrays.asList(itemReadWriteDao.findById(7L), itemReadWriteDao.findById(8L))).build());
        shopReadWriteDao.persist(Shop.builder().id(2L).name("Mr.Table").location(countryReadWriteDao.findById(2L))
                .email("table.and.brothers@gmail.com").phone("22222222").rating(5.00).isModerated(true)
                .items(Arrays.asList(itemReadWriteDao.findById(1L), itemReadWriteDao.findById(2L))).build());
        shopReadWriteDao.persist(Shop.builder().id(3L).name("Active Sport Shop").location(countryReadWriteDao.findById(3L))
                .email("sportforever.com").phone("333333333").rating(4.89).isModerated(true)
                .items(Arrays.asList(itemReadWriteDao.findById(5L), itemReadWriteDao.findById(6L))).build());
        shopReadWriteDao.persist(Shop.builder().id(4L).name("Only Mobile").location(countryReadWriteDao.findById(4L))
                .email("worldofmobile.net").email("444444444").rating(3.2).isModerated(true)
                .items(Arrays.asList(itemReadWriteDao.findById(3L), itemReadWriteDao.findById(4L))).build());
    }
}
