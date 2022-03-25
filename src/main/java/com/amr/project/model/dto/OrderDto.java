package com.amr.project.model.dto;

import com.amr.project.model.enums.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Calendar;

@Schema(description = "Заказы")
@Data
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private Calendar date;
    private Status status;
    private BigDecimal total;
    private AddressDto address;
    private UserDto user;
}
