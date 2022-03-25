package com.amr.project.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

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
