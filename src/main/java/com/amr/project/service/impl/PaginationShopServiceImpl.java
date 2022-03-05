package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.PaginationShopDao;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.PaginationShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaginationShopServiceImpl implements PaginationShopService {
    private final PaginationShopDao shopDao;

    @Autowired
    public PaginationShopServiceImpl(PaginationShopDao shopDao) {
        this.shopDao = shopDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Shop> getAllShops(Integer pageNo, Integer pageSize, String sortBy) {
        return shopDao.getAllShops(pageNo, pageSize, sortBy);
    }
}
