package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.PaginationItemDao;
import com.amr.project.model.entity.Item;
import com.amr.project.service.abstracts.PaginationItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PaginationItemServiceImpl implements PaginationItemService {
    private final PaginationItemDao itemDao;

    @Autowired
    public PaginationItemServiceImpl(PaginationItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Item> getAllItems(Integer pageNo, Integer pageSize, String sortBy) {
        return itemDao.getAllItems(pageNo, pageSize, sortBy);
    }

    @Transactional(readOnly = true)
    @Override
    public <Shop> int getTotalPagesItem(Integer pageNo, Integer pageSize) {
        return itemDao.getTotalPagesItem(pageNo, pageSize);
    }
}