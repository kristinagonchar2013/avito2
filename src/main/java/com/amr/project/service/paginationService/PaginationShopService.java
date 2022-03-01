package com.amr.project.service.paginationService;

import com.amr.project.dao.paginationRepository.PaginationShopRepository;
import com.amr.project.model.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaginationShopService {
    @Autowired
    PaginationShopRepository repositoryShop;
    public List<Shop> getAllShop(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Shop> pagedResult = repositoryShop.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Shop>();
        }
    }
}