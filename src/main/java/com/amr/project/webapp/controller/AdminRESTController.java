package com.amr.project.webapp.controller;

import com.amr.project.converter.ItemMapper;
import com.amr.project.converter.ShopMapper;
import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.ItemService;
import com.amr.project.service.abstracts.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminRESTController {
    private final ShopService shopService;
    private final ItemService itemService;
    private final ShopMapper shopMapper;
    private final ItemMapper itemMapper;

    @Autowired
    AdminRESTController(ShopService shopService, ItemService itemService, ShopMapper shopMapper, ItemMapper itemMapper) {
        this.shopService = shopService;
        this.itemService = itemService;
        this.shopMapper = shopMapper;
        this.itemMapper = itemMapper;
    }

    @PostMapping("/approve/shop/{id}")
    public ResponseEntity<ShopDto> approveShop(@PathVariable Long id) {
        Shop shop = shopService.findById(id);
        shop.setStatus("approve");
        return ResponseEntity.ok(shopMapper.shopToShopDto(shop));
    }

    @PostMapping("/notApprove/shop/{id}")
    public ResponseEntity<ShopDto> notApproveShop(@PathVariable Long id) {
        Shop shop = shopService.findById(id);
        shop.setStatus("notApprove");
        return ResponseEntity.ok(shopMapper.shopToShopDto(shop));
    }

    @PostMapping("/approve/item/{id}")
    public ResponseEntity<ItemDto> approveItem(@PathVariable Long id) {
        Item item = itemService.findById(id);
        item.setStatus("approve");
        return ResponseEntity.ok(itemMapper.itemToItemDto(item));
    }

    @PostMapping("/notApprove/item/{id}")
    public ResponseEntity<ItemDto> notApproveItem(@PathVariable Long id) {
        Item item = itemService.findById(id);
        item.setStatus("notApprove");
        return ResponseEntity.ok(itemMapper.itemToItemDto(item));
    }

}
