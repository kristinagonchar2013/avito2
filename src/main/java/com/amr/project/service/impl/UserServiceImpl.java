package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.UserDao;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.MailSenderService;
import com.amr.project.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl extends ReadWriteServiceImpl<User, Long> implements UserService {

    private final UserDao userDao;
    private final MailSenderService mailSenderService;

    @Autowired
    public UserServiceImpl(UserDao userDao, MailSenderService mailSenderService) {
        super(userDao);
        this.userDao = userDao;
        this.mailSenderService = mailSenderService;
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
        String message = String.format("Dear %s, welcome to avito. Please visit the next link: http://localhost:8080/activate/%s to activate your account",
                user.getUsername(),
                user.getActivationCode());
        mailSenderService.sendMail(user.getEmail(), "Activation code", message);
        return this.persist(user);
    }
}

