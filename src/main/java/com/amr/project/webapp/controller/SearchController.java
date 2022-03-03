package com.amr.project.webapp.controller;

import com.amr.project.converter.MainPageMapper;
import com.amr.project.model.dto.MainPageDto;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.ItemService;
import com.amr.project.service.abstracts.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final ShopService shopService;
    private final ItemService itemService;
    private final MainPageMapper mainPageMapper;

    public SearchController(ShopService shopService, ItemService itemService, MainPageMapper mainPageMapper) {
        this.shopService = shopService;
        this.itemService = itemService;
        this.mainPageMapper = mainPageMapper;
    }

    @GetMapping
    public ResponseEntity<List<MainPageDto>> searchItemOrShop(@RequestParam String keyword) {
        List<Shop> shopList = shopService.findShops(keyword);
        List<Item> itemList = itemService.findItems(keyword);
        return new ResponseEntity(mainPageMapper.mainPageToMainPageDto(shopList, itemList), HttpStatus.OK);
    }
}

