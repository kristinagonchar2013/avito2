package com.amr.project.model.dto;

import com.amr.project.model.entity.Country;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Schema(description = "Город")
@Data
@NoArgsConstructor
public class CityDto {
    private Long id;
    private String name;
    private Country country;
    private List<AddressDto> addresses;
}
