package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.dao.impl.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemService extends ReadWriteServiceImpl{

    public ItemService(ItemDao dao) {
        super(dao);
    }
}
