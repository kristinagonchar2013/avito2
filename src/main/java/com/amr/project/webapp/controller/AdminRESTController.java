package com.amr.project.webapp.controller;

import com.amr.project.service.abstracts.ItemService;
import com.amr.project.service.abstracts.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminRESTController {
    private final ShopService shopService;
    private final ItemService itemService;

    @Autowired
    AdminRESTController(ShopService shopService, ItemService itemService) {
        this.shopService = shopService;
        this.itemService = itemService;
    }

    @PostMapping("/setStatus")
    public ResponseEntity approveShop(@RequestParam Map<String,String> requestParams) {
        String nameEntity = requestParams.get("nameEntity");
        String id = requestParams.get("id");
        String status = requestParams.get("status");

        if (nameEntity.equals("shop")) {
            shopService.findById(Long.parseLong(id)).setStatus(status);
        } else if (nameEntity.equals("item")) {
            itemService.findById(Long.parseLong(id)).setStatus(status);
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
