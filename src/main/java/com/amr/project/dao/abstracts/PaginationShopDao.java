package com.amr.project.dao.abstracts;

import com.amr.project.model.entity.Shop;
import java.util.List;

public interface PaginationShopDao {
    List<Shop> getAllShops(Integer pageNo, Integer pageSize, String sortBy);
}
