package com.amr.project.webapp.controller;

import com.amr.project.converter.ItemMapper;
import com.amr.project.converter.ShopMapper;
import com.amr.project.converter.UserMapper;
import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.dto.UserDto;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.ItemService;
import com.amr.project.service.abstracts.ShopService;
import com.amr.project.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/moderator")
public class ModeratorController {
    private final UserMapper userMapper;
    private final ShopMapper shopMapper;
    private final ItemMapper itemMapper;
    private final UserService userService;
    private final ShopService shopService;
    private final ItemService itemService;

    @Autowired
    public ModeratorController(UserMapper userMapper, ShopMapper shopMapper, ItemMapper itemMapper,
                               UserService userService, ShopService shopService, ItemService itemService) {
        this.userMapper = userMapper;
        this.shopMapper = shopMapper;
        this.itemMapper = itemMapper;
        this.userService = userService;
        this.shopService = shopService;
        this.itemService = itemService;
    }

    @DeleteMapping("/delete/{nameEntity}/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id, @PathVariable String nameEntity) {
        switch (nameEntity) {
            case "user":
                User user = userService.findById(id);
                user.setPretendedToBeDeleted(true);
                break;
            case "shop":
                Shop shop = shopService.findById(id);
                shop.setPretendentToBeDeleted(true);
                break;
            case "item":
                Item item = itemService.findById(id);
                item.setPretendedToBeDeleted(true);
                break;
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/edit/{nameEntity}/{id}")
    public ResponseEntity<?> update(@RequestBody Object dto, @PathVariable Long id, @PathVariable String nameEntity) {
        ResponseEntity<?> response = null;
        switch (nameEntity) {
            case "user":
                User user = userMapper.userDtoToUser((UserDto) dto);
                user.setId(id);
                if (user.getPassword().isEmpty()) {
                    user.setPassword(userService.findById(id).getPassword());
                }
                userService.update(user);
                response = ResponseEntity.status(HttpStatus.OK).body(userMapper.userToUserDto(user));
                break;
            case "shop":
                Shop shop = shopMapper.shopDtoToShop((ShopDto) dto);
                shop.setId(id);
                shopService.update(shop);
                response = ResponseEntity.status(HttpStatus.OK).body(shopMapper.shopToShopDto(shop));
                break;
            case "item":
                Item item = itemMapper.itemDtoToItem((ItemDto) dto);
                item.setId(id);
                itemService.update(item);
                response = ResponseEntity.status(HttpStatus.OK).body(itemMapper.itemToItemDto(item));
                break;
        }
        return response;
    }

    @PostMapping("/registration/{id}")
    public ResponseEntity<ShopDto> acceptShop(@PathVariable Long id, @RequestParam boolean acceptance) {
        Shop registerShop = shopService.findById(id);
        registerShop.setModerateAccept(acceptance);
        return ResponseEntity.ok(shopMapper.shopToShopDto(registerShop));
    }
}
