package com.amr.project.webapp.controller;


import com.amr.project.converter.ItemMapper;
import com.amr.project.converter.ShopMapper;
import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.HeadPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeadPageController {


    private final ShopMapper shopMapper;
    private final ItemMapper itemMapper;
    private final HeadPageService headPageService;

    @Autowired
    public HeadPageController(ShopMapper shopMapper, ItemMapper itemMapper, HeadPageService headPageService) {
        this.shopMapper = shopMapper;
        this.itemMapper = itemMapper;
        this.headPageService = headPageService;
    }

    @GetMapping("/head_page")
    public ResponseEntity<ShopDto> show(@RequestBody ShopDto shopDto) {
        Shop shop = shopMapper.shopDtoToShop(shopDto);
        headPageService.showShop(shop);
        return ResponseEntity.ok().body(shopDto);
    }

    @GetMapping("/head_page")
    public ResponseEntity<ItemDto> show(@RequestBody ItemDto itemDto) {
        Item item = itemMapper.itemDtoToItem(itemDto);
        headPageService.showItem(item);
        return ResponseEntity.ok().body(itemDto);
    }
}
