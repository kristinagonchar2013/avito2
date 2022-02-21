package com.amr.project.model.dto;

import com.amr.project.model.entity.Country;
import lombok.Data;

@Data
public class CityDto {
    private Long id;
    private String name;
    private Country country;
}
