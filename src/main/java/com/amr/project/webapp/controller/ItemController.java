package com.amr.project.webapp.controller;

import com.amr.project.converter.ItemMapper;
import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.entity.Item;
import com.amr.project.service.abstracts.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemMapper itemMapper;
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemMapper itemMapper, ItemService itemService) {
        this.itemMapper = itemMapper;
        this.itemService = itemService;
    }

    @GetMapping("/{id}")
    ResponseEntity<ItemDto> getItemById(@PathVariable Long id) {
        Item item = itemService.findById(id);
        return ResponseEntity.ok(itemMapper.itemToItemDto(item));
    }

    @PostMapping
    ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto) {
        itemService.persist(itemMapper.itemDtoToItem(itemDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(itemDto);
    }

    @PutMapping
    ResponseEntity<ItemDto> updateItem(@RequestBody ItemDto itemDto, @PathVariable Long id) {
        Item item = itemMapper.itemDtoToItem(itemDto);
        item.setId(id);
        itemService.update(item);
        return ResponseEntity.status(HttpStatus.OK).body(itemMapper.itemToItemDto(item));
    }
}
