package com.amr.project.webapp.controller;

import com.amr.project.converter.MainPageMapper;
import com.amr.project.model.dto.MainPageDto;
import com.amr.project.model.entity.Category;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.CategoryService;
import com.amr.project.service.abstracts.ItemService;
import com.amr.project.service.abstracts.ShopService;
import com.amr.project.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainPageController {


    private final MainPageMapper mainPageMapper;
    private final ShopService shopService;
    private final ItemService itemService;
    private final CategoryService categoryService;
    private final UserService userService;

    @Autowired
    public MainPageController(MainPageMapper mainPageMapper, ShopService shopService, ItemService itemService, CategoryService categoryService, UserService userService) {
        this.mainPageMapper = mainPageMapper;
        this.shopService = shopService;
        this.itemService = itemService;
        this.categoryService = categoryService;
        this.userService = userService;
    }


    @GetMapping("/main_page/{id}")
    public ResponseEntity<MainPageDto> show (@PathVariable Long id,@RequestParam String search) {
        List<Shop> shopList = shopService.findShops(search);//поменяем метод
        List <Item> itemList = itemService.findItems(search);//поменяем метод
        shopList.sort(Shop::compareTo);
        itemList.sort(Item::compareTo);
        List<Category> categoryList = categoryService.findAll();
        User user = userService.findById(id);
        //пагинация пока не готова
        return ResponseEntity.ok().body(mainPageMapper.mainPageToMainPageDtoHead(shopList,itemList,categoryList,user));

    }
}
