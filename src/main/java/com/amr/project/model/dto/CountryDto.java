package com.amr.project.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Schema(description = "Страна")
@Data
@NoArgsConstructor
public class CountryDto {
    private Long id;
    private String name;
    private List<CityDto> cities;
}
