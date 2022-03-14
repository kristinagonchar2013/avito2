package com.amr.project.webapp.controller;

import com.amr.project.converter.RegistrationMapper;
import com.amr.project.model.dto.RegistrationDto;
import com.amr.project.service.abstracts.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private final UserService userService;
    private final RegistrationMapper registrationMapper;

    public RegistrationController(UserService userService, RegistrationMapper registrationMapper) {
        this.userService = userService;
        this.registrationMapper = registrationMapper;
    }

    @GetMapping("/activation/{code}")
    public ResponseEntity<RegistrationDto> activate(@PathVariable String code) {
        boolean isActivated = userService.activateUser(code);
        String message;
        if (isActivated) {
            message = "User successfully activated";
        } else
            message = "Activation code is not found";
        return ResponseEntity.ok(registrationMapper.MessageToRegistrationDTO(message);
    }
}
