package com.amr.project.service.abstracts;

import org.springframework.security.core.userdetails.User;

public interface UserService {

    void createUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    void deleteById(Long id);

}
