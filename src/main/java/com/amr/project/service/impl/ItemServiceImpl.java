package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ItemDao;
import com.amr.project.model.entity.Item;
import com.amr.project.model.enums.EstablishedStatus;
import com.amr.project.service.abstracts.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl extends ReadWriteServiceImpl<Item, Long> implements ItemService {
    private ItemDao dao;
    @Autowired
    public ItemServiceImpl(ItemDao dao) {
        super(dao);
    }

    @Override
    public List<Item> findAllByStatus(EstablishedStatus establishedStatus) {
        return dao.findAllByStatus(establishedStatus);
    }
}
