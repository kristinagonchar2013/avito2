package com.amr.project.dao.impl;


import com.amr.project.dao.abstracts.MainPageDao;
import com.amr.project.model.entity.Category;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import com.amr.project.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MainPageDaoImpl implements MainPageDao {


    @Override
    public void showMainPage(List<Shop> shopList, List<Item> itemList, List<Category> categoryList, User user) {

    }
}
