package com.amr.project.dao.impl;


import com.amr.project.dao.abstracts.HeadPageDao;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HeadPageDaoImpl implements HeadPageDao {


    @Override
    public void showShop(Shop shop) {
        List <Shop> shopList;
    }

    @Override
    public void showItem(Item item) {
      List <Item> itemList;
    }
}
