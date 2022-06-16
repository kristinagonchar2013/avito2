package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ShopDao;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl extends ReadWriteServiceImpl<Shop, Long> implements ShopService {
    private final ShopDao shopDao;
    private static final Logger logger = LoggerFactory.getLogger(ShopServiceImpl.class);

    public ShopServiceImpl(ShopDao dao) {
        super(dao);
        this.shopDao = dao;
    }

    @Override
    public List<Shop> findShops(String keyword) {
        logger.info(keyword);
        return shopDao.findShops(keyword);
    }
}
