package com.amr.project.service.abstracts;


import com.amr.project.dao.abstracts.MainPageDao;
import com.amr.project.model.entity.Category;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import com.amr.project.model.entity.User;

import java.util.List;


public interface MainPageService extends MainPageDao {

    @Override
    void showMainPage(List<Shop> shopList, List<Item> itemList, List<Category> categoryList, User user);
}
