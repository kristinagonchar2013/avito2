package com.amr.project.service.abstracts;

import com.amr.project.model.entity.Shop;
import java.util.List;

public interface PaginationShopService {
    List<Shop> getAllShops(Integer pageNo, Integer pageSize, String sortBy);
    <Shop> int getTotalPagesShop(Integer pageNo, Integer pageSize);
}