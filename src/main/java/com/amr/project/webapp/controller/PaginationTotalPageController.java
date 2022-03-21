package com.amr.project.webapp.controller;

import com.amr.project.converter.ItemMapper;
import com.amr.project.converter.ShopMapper;
import com.amr.project.service.abstracts.PaginationItemService;
import com.amr.project.service.abstracts.PaginationShopService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Total")
public class PaginationTotalPageController {
    private final ShopMapper mapper;
    private final PaginationShopService service;
    private final ItemMapper map;
    private final PaginationItemService serv;

    public PaginationTotalPageController(ShopMapper mapper, PaginationShopService service, ItemMapper map, PaginationItemService service1) {
        this.mapper = mapper;
        this.service = service;
        this.map = map;
        this.serv = service1;
    }

    @GetMapping("/Shop")
    public ResponseEntity<Integer> getTotalPageShop(@RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "6") Integer pageSize) {
        int page = service.getTotalPagesShop(pageNo, pageSize);
        return new ResponseEntity<Integer>(page, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/Item")
    public ResponseEntity<Integer> getTotalPageItem(@RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "4") Integer pageSize) {
        int page = serv.getTotalPagesItem(pageNo, pageSize);
        return new ResponseEntity<Integer>(page, new HttpHeaders(), HttpStatus.OK);
    }
}
