package com.amr.project.dao.abstracts;


import com.amr.project.model.entity.Category;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import com.amr.project.model.entity.User;

import java.util.List;

public interface MainPageDao {
    void showMainPage (List<Shop> shopList, List<Item> itemList,
                       List <Category> categoryList, User user);
}
