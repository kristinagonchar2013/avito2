package com.amr.project.webapp.controller;


import com.amr.project.converter.MainPageMapper;
import com.amr.project.model.dto.MainPageDto;
import com.amr.project.model.entity.Category;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.CategoryService;
import com.amr.project.service.abstracts.ItemService;
import com.amr.project.service.abstracts.MainPageService;
import com.amr.project.service.abstracts.ShopService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class MainPageController {


    private final MainPageMapper mainPageMapper;
    private final MainPageService mainPageService;
    private final ShopService shopService;
    private final ItemService itemService;
    private final CategoryService categoryService;

    @Autowired
    public MainPageController(MainPageMapper mainPageMapper, MainPageService mainPageService, ShopService shopService, ItemService itemService, CategoryService categoryService) {
        this.mainPageMapper = mainPageMapper;
        this.mainPageService = mainPageService;
        this.shopService = shopService;
        this.itemService = itemService;
        this.categoryService = categoryService;
    }


    @GetMapping("/main_page")
    public ResponseEntity<MainPageDto> show () {
        List<Shop> shopList = shopService.findAll();//поменяем метод
        List <Item> itemList = itemService.findAll();
        List<Category> categoryList = categoryService.findAll();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = auth.getPrincipal();
        MainPageDto mainPageDto = mainPageMapper.mainPageToMainPageDto(shopList,itemList,categoryList,user);
        return ResponseEntity.ok().body(mainPageDto);

    }
}
