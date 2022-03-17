package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ShopDao;
import com.amr.project.model.entity.Shop;
import com.amr.project.model.enums.EstablishedStatus;
import com.amr.project.service.abstracts.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl extends ReadWriteServiceImpl<Shop, Long> implements ShopService {

    private ShopDao dao;

    @Autowired
    public ShopServiceImpl(ShopDao dao) {
        super(dao);
    }


    @Override
    public List<Shop> findAllByStatus(EstablishedStatus establishedStatus) {
        return dao.findAllByStatus(establishedStatus);
    }
}
