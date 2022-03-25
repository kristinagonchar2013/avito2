package com.amr.project.model.dto;

import com.amr.project.model.entity.Country;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CityDto {
    private Long id;
    private String name;
    private Country country;
    private List<AddressDto> addresses;
}
