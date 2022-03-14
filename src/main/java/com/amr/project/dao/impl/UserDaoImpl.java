package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.UserDao;
import com.amr.project.model.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl extends ReadWriteDaoImpl<User, Long> implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User findByActivationCode(String code) {
        User user = entityManager.createQuery("SELECT u FROM User u WHERE u.activationCode =: activationCode", User.class)
                .setParameter("activationCode", code).getSingleResult();
        return user;
    }

}
