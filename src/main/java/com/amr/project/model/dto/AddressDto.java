package com.amr.project.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Адрес")
@Data
@NoArgsConstructor
public class AddressDto {

    private Long id;
    private String cityIndex;
    private String street;
    private String house;
    private CityDto city;
    private UserDto user;
}
