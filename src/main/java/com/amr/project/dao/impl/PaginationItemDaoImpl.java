package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.PaginationItemDao;
import com.amr.project.model.entity.Item;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PaginationItemDaoImpl extends  PaginationUtilDaoImpl<Item> implements PaginationItemDao {

    @Override
    public List<Item> getAllItems(Integer pageNo, Integer pageSize, String sortBy) {
        return getAllEntities(pageNo, pageSize, sortBy);
    }
    @Override
    public <Item> int getTotalPagesItem(Integer pageNo, Integer pageSize) {
        return getTotalPages(pageNo, pageSize);
    }
}
