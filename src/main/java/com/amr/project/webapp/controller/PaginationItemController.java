package com.amr.project.webapp.controller;

import com.amr.project.converter.ItemMapper;
import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.entity.Item;
import com.amr.project.service.paginationService.PaginationItemService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/items")
public class PaginationItemController {
    private final ItemMapper mapper;
    private final PaginationItemService service;

    public PaginationItemController(ItemMapper mapper, PaginationItemService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ItemDto>> getAllItem(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "4") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        List<Item> list = service.getAllItem(pageNo, pageSize, sortBy);
        return new ResponseEntity<List<ItemDto>>(mapper.allItemsToItemsDto(list), new HttpHeaders(), HttpStatus.OK);
    }
}