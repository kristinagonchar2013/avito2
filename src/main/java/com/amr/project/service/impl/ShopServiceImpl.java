package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ShopDao;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.ShopService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl extends ReadWriteServiceImpl<Shop, Long> implements ShopService {

    private final ShopDao shopDao;

    public ShopServiceImpl(ShopDao dao) {
        super(dao);
        this.shopDao = dao;
    }

    @Override
    public List<Shop> findShops(String keyword) {
        return shopDao.findShops(keyword);
    }
}
