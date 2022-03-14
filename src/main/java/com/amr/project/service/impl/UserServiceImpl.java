package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.UserDao;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.MailSenderService;
import com.amr.project.service.abstracts.UserService;
import org.mapstruct.ap.shaded.freemarker.template.utility.StringUtil;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl extends ReadWriteServiceImpl<User, Long> implements UserService {

    private final UserDao userDao;
    private final MailSenderService mailSenderService;

    public UserServiceImpl(UserDao userDao, MailSenderService mailSenderService) {
        super(userDao);
        this.userDao = userDao;
        this.mailSenderService = mailSenderService;
    }

    @Override
    public Optional<User> findByUsername(String name) {
        return userDao.findByUsername(name);
    }

    @Override
    public boolean activateUser(String code) {
        User user = userDao.findByActivationCode(code);
        if (user == null) {
            return false;
        }
        user.setActivationCode(null);
        userDao.persist(user);
        return true;
    }

    @Override
    public User persist(User user) {
        user.setActivate(true);
        user.setRole(user.getRole());
        user.setActivationCode(UUID.randomUUID().toString());
        String message = String.format("Dear %s, welcome to Avito2. Please, visit next link http://localhost:8080/activation/%s to activate your account",
                user.getUsername(),
                user.getActivationCode());

        mailSenderService.sendMail(user.getEmail(), "Activation code", message);
        return this.persist(user);
    }
}

