package com.amr.project.dao.paginationRepository;

import com.amr.project.model.entity.Item;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaginationItemRepository
        extends PagingAndSortingRepository<Item, Long> {
}