package com.amr.project.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CountryDto {
    private Long id;
    private String name;
    private List<CityDto> cities;
}
