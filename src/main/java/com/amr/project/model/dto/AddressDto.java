package com.amr.project.model.dto;

import com.amr.project.model.entity.City;
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
    private City city;
}
