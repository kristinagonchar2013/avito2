package com.amr.project.dao.abstracts;

import java.util.List;

public interface PaginationUtilDao<T> {
    List<T>  getAllEntities(Integer pageNo, Integer pageSize, String sortBy);
    <T> int getTotalPages(Integer pageNo, Integer pageSize);
}
