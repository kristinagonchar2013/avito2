package com.amr.project.service.abstracts;

import com.amr.project.model.entity.Image;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;



public interface HeadPageService {

    void showShop (Shop shop);
    void showItem (Item item);

}
