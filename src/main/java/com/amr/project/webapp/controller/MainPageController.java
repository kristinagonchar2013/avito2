package com.amr.project.webapp.controller;

import com.amr.project.converter.MainPageMapper;
import com.amr.project.model.dto.MainPageDto;
import com.amr.project.model.entity.Category;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

@RestController
public class MainPageController {


    private final MainPageMapper mainPageMapper;
    private final ShopService shopService;
    private final ItemService itemService;
    private final CategoryService categoryService;
    private final UserService userService;
    private final PaginationItemService paginationItemService;
    private final PaginationShopService paginationShopService;

    @Autowired
    public MainPageController(MainPageMapper mainPageMapper, ShopService shopService, ItemService itemService, CategoryService categoryService, UserService userService, PaginationItemService paginationItemService, PaginationShopService paginationShopService) {
        this.mainPageMapper = mainPageMapper;
        this.shopService = shopService;
        this.itemService = itemService;
        this.categoryService = categoryService;
        this.userService = userService;
        this.paginationItemService = paginationItemService;
        this.paginationShopService = paginationShopService;
    }


    @GetMapping("/main_page/{pageNo}/{pageSize}")
    public ResponseEntity<MainPageDto> showMainPage( @RequestParam(defaultValue = "0") Integer pageNo,
                                                     @RequestParam(defaultValue = "4") Integer pageSize,
                                                     @RequestParam(defaultValue = "rating") String sortBy) {
        List<Shop> shopList = paginationShopService.getAllShops(pageNo, pageSize, sortBy);
        List <Item> itemList = paginationItemService.getAllItems(pageNo, pageSize, sortBy);
        List<Category> categoryList = categoryService.findAll();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok().body(mainPageMapper.mainPageToMainPageDtoHead(shopList,itemList,categoryList,user));
    }

}
