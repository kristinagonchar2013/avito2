package com.amr.project.model.dto;

import com.amr.project.model.entity.Address;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.OrderDetail;
import com.amr.project.model.entity.User;
import com.amr.project.model.enums.Status;


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class OrderDto {

    private Long id;
    private Calendar date;
    private Status status;
    private BigDecimal total;
    private String buyerName;
    private String buyerPhone;
    private List<ItemDto> items;
    private AddressDto address;
    private OrderDetailDto orderDetail;
}
