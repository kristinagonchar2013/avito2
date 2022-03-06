package com.amr.project.model.dto;

import com.amr.project.model.entity.Country;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CityDto {
    private Long id;
    private String name;
    private Country country;
}
