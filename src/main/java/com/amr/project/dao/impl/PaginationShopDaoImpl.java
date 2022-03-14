package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.PaginationShopDao;
import com.amr.project.model.entity.Shop;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PaginationShopDaoImpl implements PaginationShopDao {

    @Override
    public List<Shop> getAllShops(Integer pageNo, Integer pageSize, String sortBy) {
        return PaginationUtil.getAllEntities(pageNo, pageSize, sortBy);
    }
}
