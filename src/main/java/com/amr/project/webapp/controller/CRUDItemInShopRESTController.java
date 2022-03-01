package com.amr.project.webapp.controller;

import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.ReadWriteService;
import com.amr.project.service.impl.ItemService;
import com.amr.project.service.impl.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/shop")
public class CRUDItemInShopRESTController {
    private final ShopService shopService;
    private final ItemService itemService;
    private final ItemMapper itemMapper;
    @Autowired
    public CRUDItemInShopRESTController(ShopService shopService, ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.shopService = shopService;
        this.itemMapper = itemMapper;
    }

    @PostMapping("/{id}/item")
    public ResponseEntity<ItemDto> addItemInShop(@Valid @RequestBody ItemDto itemDto, @PathVariable Long id) {
        Item item = itemMapper.itemDtoToItem(itemDto);
        Shop shop = (Shop) shopService.findById(id);
        shop.getItems().add(item);
        shopService.persist(shop);
        return ResponseEntity.ok(itemDto);
    }

    @PutMapping("/item")
    public ResponseEntity<ItemDto> updateItemInShop(@Valid @RequestBody ItemDto itemDto, @PathVariable Long id) {
        Item item = itemMapper.itemDtoToItem(itemDto);
        itemService.update(item);
        return ResponseEntity.ok(itemDto);
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Item item = (Item) itemService.findById(id);
        itemService.delete(item);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
