package com.amr.project.model.dto;

import com.amr.project.model.entity.Order;
import java.util.List;

public class CartItemDto {

    private Long id;
    private String anonID;
    private int quantity;
    private List<Order> orders;
}
