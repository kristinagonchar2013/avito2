package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.dao.abstracts.UserDao;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.EmailService;
import com.amr.project.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl extends ReadWriteServiceImpl<User, Long> implements UserService {

    private final UserDao userDao;
    private final EmailService emailService;

    @Autowired
    public UserServiceImpl(ReadWriteDao<User, Long> dao, UserDao userDao, EmailService emailService) {
        super(dao);
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @Override
    public boolean activateUser(String code) {
        User user = userDao.findByActivationCode(code);
        if (user == null) {
            return false;
        }
        user.setActivate(true);
        user.setActivationCode(null);
        return true;
    }

    @Override
    public User persist(User user) {
        user.setActivate(false);
        user.setActivationCode(UUID.randomUUID().toString());
        String message = String.format("Dear %s, welcome to avito. Please visit the next link: http://localhost:8080/activate/%s to activate your account",
                user.getUsername(),
                user.getActivationCode());
        emailService.sendMailActivation(user.getEmail(), "Activation code", message);
        return this.persist(user);
    }
}

