package com.amr.project.webapp.controller;

import com.amr.project.converter.ShopMapper;
import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
@Tag(name = "Shop Rest Controller", description = "Контроллер для CRUD операций с магазином")
public class ShopController {

    private final ShopMapper mapper;
    private final ShopService service;

    @Autowired
    public ShopController(ShopMapper mapper, ShopService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    @Operation(description = "Вывод всех магазинов")
    public ResponseEntity<List<ShopDto>> findAll() {
        List<Shop> list = service.findAll();
        return ResponseEntity.ok(mapper.allShopsToShopsDto(list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopDto> getOneShop(@PathVariable Long id) {
        Shop shop = service.findById(id);
        return ResponseEntity.ok(mapper.shopToShopDto(shop));
    }

    @PostMapping
    public ResponseEntity<ShopDto> createShop(@RequestBody ShopDto shopDto) {
        service.persist(mapper.shopDtoToShop(shopDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(shopDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShopDto> updateShop(@RequestBody ShopDto shopDto, @PathVariable Long id) {
        Shop shop = mapper.shopDtoToShop(shopDto);
        shop.setId(id);
        service.update(shop);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.shopToShopDto(shop));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShopById(@PathVariable Long id) {
        service.delete(service.findById(id));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
