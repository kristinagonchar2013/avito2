package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.HeadPageDao;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.HeadPageService;
import org.springframework.stereotype.Service;

@Service
public class HeadPageServiceImpl implements HeadPageService {

    private final HeadPageDao headPageDao;

    public HeadPageServiceImpl(HeadPageDao headPageDao) {
        this.headPageDao = headPageDao;
    }


    @Override
    public void showShop(Shop shop) {
        headPageDao.showShop(shop);
    }

    @Override
    public void showItem(Item item) {
        headPageDao.showItem(item);
    }
}
