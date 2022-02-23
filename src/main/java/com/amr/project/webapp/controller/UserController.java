package com.amr.project.webapp.controller;

import com.amr.project.converter.MapStructMapper;
import com.amr.project.model.dto.UserDto;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.ReadWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController  {

    private final ReadWriteService <User,Long> userServiceRead;
    private final MapStructMapper mapper;

    @Autowired
    public UserController(ReadWriteService userServiceRead, MapStructMapper mapper) {
        this.userServiceRead = userServiceRead;
        this.mapper = mapper;
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userServiceRead.delete(userServiceRead.findById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        User user = mapper.userDtoToUser(userDto);
        userServiceRead.persist(user);
        return ResponseEntity.ok().body(userDto);
    }
    @PutMapping("/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        User user = mapper.userDtoToUser(userDto);
        userServiceRead.update(user);
        return ResponseEntity.ok().body(userDto);
    }
}
