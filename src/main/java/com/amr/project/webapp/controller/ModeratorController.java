package com.amr.project.webapp.controller;

import com.amr.project.converter.UserMapper;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ModeratorController {
    private UserMapper userMapper;
    private UserService userService;

    @Autowired
    public UserAdminController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        user.setPretendedToBeDeleted(true);
            userService.deleteByIdCascadeEnable(id);
            return ResponseEntity.status(HttpStatus.OK).build();

    }
}
