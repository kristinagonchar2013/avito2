package com.amr.project.dao.abstracts;


import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;

public interface UserDao extends CrudRepository<User, Long> {


}
