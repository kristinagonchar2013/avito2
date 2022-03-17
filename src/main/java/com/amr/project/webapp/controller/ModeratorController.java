package com.amr.project.webapp.controller;

import com.amr.project.converter.UserMapper;
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
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/moderator")
public class ModeratorController {
    private final UserMapper userMapper;
    private final UserService userService;
    private final ShopService shopService;
    private final ItemService itemService;

    @Autowired
    public ModeratorController(UserMapper userMapper, UserService userService, ShopService shopService, ItemService itemService) {
        this.userMapper = userMapper;
        this.userService = userService;
        this.shopService = shopService;
        this.itemService = itemService;
    }

    @DeleteMapping("/delete")
    ResponseEntity deleteById(@RequestParam Map<String, String> request) {
        String nameEntity = request.get("nameEntity");
        String id = request.get("id");
        if (nameEntity.equals("user")) {
            User user = userService.findById(Long.parseLong(id));
            user.setPretendedToBeDeleted(true);
        } else if (nameEntity.equals("shop")) {
            Shop shop = shopService.findById(Long.parseLong(id));
            shop.setPretendentToBeDeleted(true);
        } else if (nameEntity.equals("item")) {
            Item item = itemService.findById(Long.parseLong(id));
            item.setPretendedToBeDeleted(true);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UserDto> updateShop(@RequestBody Map<String, String> requestBody, @PathVariable Long id) {
        User user = userMapper.userDtoToUser(userDto);
        user.setId(id);
        if (user.getPassword().isEmpty()) {
            user.setPassword(userService.findById(id).getPassword());
        }
        userService.update(user);
        return ResponseEntity.status(HttpStatus.OK).body(userMapper.userToUserDto(user));
    }
}
