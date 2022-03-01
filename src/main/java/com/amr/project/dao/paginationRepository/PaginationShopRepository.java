package com.amr.project.dao.paginationRepository;

import com.amr.project.model.entity.Shop;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaginationShopRepository
        extends PagingAndSortingRepository<Shop, Long> {
}