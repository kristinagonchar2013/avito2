package com.amr.project.model.dto;

import com.amr.project.model.entity.City;
import lombok.Data;

@Data
public class AddressDto {

    private Long id;
    private String cityIndex;
    private String street;
    private String house;
    private City city;
}
