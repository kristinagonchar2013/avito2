package com.amr.project.webapp.config.datainitializeronstartup;

import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.model.entity.User;
import com.amr.project.model.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class UserDataInit {
    private final ReadWriteDao<User, Long> userReadWriteDao;

    @Autowired
    public UserDataInit(ReadWriteDao<User, Long> userReadWriteDao) {
        this.userReadWriteDao = userReadWriteDao;
    }

    @PostConstruct
    private void userDataInit() {
        userReadWriteDao.persist(User.builder().id(1L).email("user@init.com").username("user").password("user")
                .activate(true).firstName("user").lastName("user").roles(Arrays.asList(Role.USER)).build());
        userReadWriteDao.persist(User.builder().id(2L).email("admin@init.com").username("admin").password("admin")
                .activate(true).firstName("admin").lastName("admin").roles(Arrays.asList(Role.ADMINISTRATOR)).build());
        userReadWriteDao.persist(User.builder().id(3L).email("moderator@init.com").username("moderator").password("moderator")
                .activate(true).firstName("moderator").lastName("moderator").roles(Arrays.asList(Role.MODERATOR, Role.ADMINISTRATOR))
                .build());
    }
}