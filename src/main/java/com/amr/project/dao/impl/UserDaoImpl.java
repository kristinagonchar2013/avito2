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
    public Optional<User> findByUsername(String name) {
        List<User> users = entityManager.createQuery("SELECT u FROM User u JOIN FETCH u.role WHERE u.firstName =:name", User.class)
                .setParameter("name", name).getResultList();
        return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
    }

}
