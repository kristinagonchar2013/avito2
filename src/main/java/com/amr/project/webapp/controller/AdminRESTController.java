package com.amr.project.webapp.controller;

import com.amr.project.converter.ItemMapper;
import com.amr.project.converter.ShopMapper;
import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.Shop;
import com.amr.project.model.enums.EstablishedStatus;
import com.amr.project.service.abstracts.ItemService;
import com.amr.project.service.abstracts.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminRESTController {
    private final ShopService shopService;
    private final ItemService itemService;
    private final ShopMapper shopMapper;
    private final ItemMapper itemMapper;

    @Autowired
    AdminRESTController(ShopService shopService, ItemService itemService,
                        ShopMapper shopMapper, ItemMapper itemMapper) {
        this.shopService = shopService;
        this.itemService = itemService;
        this.shopMapper = shopMapper;
        this.itemMapper = itemMapper;
    }

    @PostMapping("/setStatus")
    public ResponseEntity setStatus(@RequestParam Object obj) {

        if (obj.equals(ShopDto.class)) {
            shopService.update(shopMapper.shopDtoToShop((ShopDto)obj));
        } else if (obj.equals(ItemDto.class)) {
            itemService.update(itemMapper.itemDtoToItem((ItemDto)obj));
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
