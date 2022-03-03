package com.amr.project.webapp.controller;


import com.amr.project.converter.UserMapper;
import com.amr.project.model.dto.UserDto;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    @Autowired
    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getOne(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(userMapper.userToUserDto(user));
    }

    @PostMapping
    public ResponseEntity<UserDto> createShop(@RequestBody UserDto userDto) {
        userService.persist(userMapper.userDtoToUser(userDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateShop(@RequestBody UserDto userDto, @PathVariable Long id) {
        User user = userMapper.userDtoToUser(userDto);
        user.setId(id);
        // такую проверку пароля??
        if (user.getPassword().isEmpty()) {
            user.setPassword(userService.findById(id).getPassword());
        }

        userService.update(user);
        return ResponseEntity.status(HttpStatus.OK).body(userMapper.userToUserDto(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteShopById(@PathVariable Long id) {
        userService.delete(userService.findById(id));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
