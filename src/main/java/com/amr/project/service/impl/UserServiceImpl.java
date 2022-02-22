package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.UserDao;
import com.amr.project.service.abstracts.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUser(User user) {
        userDao.save(user);
    }
    @Override
    public void updateUser(User user) {
        userDao.save(user);

    }
    @Override
    public void deleteUser(User user) {
        userDao.delete(user);

    }
    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

}
