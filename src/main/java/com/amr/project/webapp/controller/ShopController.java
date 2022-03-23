package com.amr.project.webapp.controller;

import com.amr.project.converter.ShopMapper;
import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Вывод всех магазинов")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK, возвращает список магазинов")
    })
    public ResponseEntity<List<ShopDto>> findAll() {
        List<Shop> list = service.findAll();
        return ResponseEntity.ok(mapper.allShopsToShopsDto(list));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Вывод магазина по его id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK, возвращает один магазин")
    })
    public ResponseEntity<ShopDto> getOneShop(@Parameter(description = "Идентификатор пользователя")
                                                  @PathVariable Long id) {
        Shop shop = service.findById(id);
        return ResponseEntity.ok(mapper.shopToShopDto(shop));
    }

    @PostMapping
    @Operation(summary = "Создание магазина")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "CREATED, возвращает только созданный магазин")
    })
    public ResponseEntity<ShopDto> createShop(@RequestBody ShopDto shopDto) {
        service.persist(mapper.shopDtoToShop(shopDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(shopDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновление магазина по его id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK, возвращает обновленный магазин")
    })
    public ResponseEntity<ShopDto> updateShop(@RequestBody ShopDto shopDto
            , @Parameter(description = "Идентификатор пользователя")  @PathVariable Long id) {
        Shop shop = mapper.shopDtoToShop(shopDto);
        shop.setId(id);
        service.update(shop);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.shopToShopDto(shop));
    }

    @DeleteMapping("/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "возвращает только Http status \"OK\"")
    })
    @Operation(summary = "Удаление магазина по его id")
    public ResponseEntity<Void> deleteShopById(@Parameter(description = "Идентификатор пользователя")
                                                   @PathVariable Long id) {
        service.delete(service.findById(id));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
