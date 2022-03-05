package com.amr.project.webapp.controller;

import com.amr.project.converter.ShopMapper;
import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.PaginationShopService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/shops")
public class PaginationShopController {
    private final ShopMapper mapper;
    private final PaginationShopService service;

    public PaginationShopController(ShopMapper mapper, PaginationShopService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ShopDto>> getAllShop(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "6") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        List<Shop> list = service.getAllShops(pageNo, pageSize, sortBy);
        return new ResponseEntity<List<ShopDto>>(mapper.allShopsToShopsDto(list), new HttpHeaders(), HttpStatus.OK);
    }
}