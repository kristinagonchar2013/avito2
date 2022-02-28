package com.amr.project.webapp.controller;

import com.amr.project.converter.MapStructMapper;
import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.ReadWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/shop")
public class CRUDItemInShopRESTController {

    private final ReadWriteService<Item, Long> itemService;
    private final ReadWriteService<Shop, Long> shopService;
    private final MapStructMapper mapper;

    @Autowired
    public CRUDItemInShopRESTController(ReadWriteService<Item, Long> itemService, ReadWriteService<Shop, Long> shopService,
                                        MapStructMapper mapper) {
        this.shopService = shopService;
        this.itemService = itemService;
        this.mapper = mapper;
    }

    @PostMapping("/{id}/item")
    public ResponseEntity<ItemDto> addItemInShop(@Valid @RequestBody ItemDto itemDto, @PathVariable Long id) {
        Item item = mapper.itemDtoToItem(itemDto);
        Shop shop = (Shop) shopService.findById(id);
        shop.addItem(item);
        shopService.persist(shop);
        return ResponseEntity.ok(itemDto);
    }

    @PutMapping("/item")
    public ResponseEntity<ItemDto> updateItemInShop(@Valid @RequestBody ItemDto itemDto, @PathVariable Long id) {
        Item item = mapper.itemDtoToItem(itemDto);
        itemService.update(item);
        return ResponseEntity.ok(itemDto);
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Item item = itemService.findById(id);
        itemService.delete(item);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
