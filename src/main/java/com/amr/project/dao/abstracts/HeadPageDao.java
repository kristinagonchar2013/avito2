package com.amr.project.dao.abstracts;


import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;

public interface HeadPageDao {
    void showShop (Shop shop);
    void showItem (Item item);

}
