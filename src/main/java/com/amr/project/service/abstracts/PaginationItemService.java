package com.amr.project.service.abstracts;

import com.amr.project.model.entity.Item;
import java.util.List;

public interface PaginationItemService {
    List<Item> getAllItems(Integer pageNo, Integer pageSize, String sortBy);
}