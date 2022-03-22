package com.amr.project.dao.abstracts;
import com.amr.project.model.entity.Item;
import java.util.List;

public interface  PaginationItemDao {
    List<Item> getAllItems(Integer pageNo, Integer pageSize, String sortBy);
    <Item> int getTotalPagesItem(Integer pageNo, Integer pageSize);
}