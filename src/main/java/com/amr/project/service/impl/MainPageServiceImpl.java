package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.MainPageDao;
import com.amr.project.model.entity.Category;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.MainPageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainPageServiceImpl implements MainPageService {

    private final MainPageDao mainPageDao;

    public MainPageServiceImpl(MainPageDao mainPageDao) {
        this.mainPageDao = mainPageDao;
    }


    @Override
    public void showMainPage(List<Shop> shopList, List<Item> itemList, List<Category> categoryList, User user) {

    }

}


