package com.amr.project.dao.abstracts;

import com.amr.project.model.entity.User;

import java.util.Optional;

public interface UserDao extends ReadWriteDao<User, Long> {
    Optional<User> findByUsername(String name);

    User findByActivationCode(String code);
}
