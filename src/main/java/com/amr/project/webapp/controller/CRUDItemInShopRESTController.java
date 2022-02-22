package com.amr.project.webapp.controller;

import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.ReadWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/shop")
public class CRUDItemInShopRESTController {

    private final ReadWriteService shopService;
    private final Converter converter;

    @Autowired
    public CRUDItemInShopRESTController(ReadWriteService shopService, Converter converter) {
        this.shopService = shopService;
        this.converter = converter;
    }

    @PostMapping("/{id}/item")
    public ResponseEntity<ItemDto> addItemInShop(@Valid @RequestBody ItemDto itemDto, @PathVariable Long id) {
        Item item = converter.itemDtoToItem(itemDto);
        Shop shop = (Shop) shopService.findById(id);
        shop.addItem(item);
        shopService.persist(shop);
        return ResponseEntity.ok(itemDto);
    }

    @PutMapping("/item")
    public ResponseEntity<ItemDto> updateItemInShop(@Valid @RequestBody ItemDto itemDto, @PathVariable Long id) {
        Item item = converter.convetToItem(itemDto);

        return ResponseEntity.ok(shopService.update(item));
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
