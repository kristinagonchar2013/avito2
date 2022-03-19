package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.ChatDao;
import com.amr.project.model.entity.Chat;
import org.springframework.stereotype.Repository;

@Repository
public class ChatDaoImpl extends ReadWriteDaoImpl<Chat, Long> implements ChatDao {
}
