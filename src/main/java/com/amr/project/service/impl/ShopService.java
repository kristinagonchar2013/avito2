package com.amr.project.service.impl;

import com.amr.project.dao.impl.ShopDao;

public class ShopService extends ReadWriteServiceImpl{
    public ShopService(ShopDao dao) {
        super(dao);
    }
}
