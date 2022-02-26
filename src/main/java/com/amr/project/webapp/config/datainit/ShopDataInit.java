package com.amr.project.webapp.config.datainit;

import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.model.entity.Country;
import com.amr.project.model.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShopDataInit {

    private final ReadWriteDao<Shop, Long> shopReadWriteDao;
    private final ReadWriteDao<Country, Long> countryReadWriteDao;

    @Autowired
    public ShopDataInit(ReadWriteDao<Shop, Long> shopReadWriteDao, ReadWriteDao<Country, Long> countryReadWriteDao) {
        this.shopReadWriteDao = shopReadWriteDao;
        this.countryReadWriteDao = countryReadWriteDao;
    }

    public void shopDataInit() {
        shopReadWriteDao.persist(Shop.builder().id(1L).name("First Shop").location(countryReadWriteDao.findById(1L))
                .build());
        shopReadWriteDao.persist(Shop.builder().id(1L).name("First Shop").location(countryReadWriteDao.findById(1L))
                .build());
        shopReadWriteDao.persist(Shop.builder().id(1L).name("First Shop").location(countryReadWriteDao.findById(1L))
                .build());
        shopReadWriteDao.persist(Shop.builder().id(1L).name("First Shop").location(countryReadWriteDao.findById(1L))
                .build());
    }
}
