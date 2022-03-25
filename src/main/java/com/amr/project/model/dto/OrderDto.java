package com.amr.project.model.dto;

import com.amr.project.model.enums.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@Data
public class OrderDto {

    private Long id;
    private Calendar date;
    private Status status;
    private BigDecimal total;
    private AddressDto address;
    private List<CartItemDto> cartItems;
    private UserDto user;
}
