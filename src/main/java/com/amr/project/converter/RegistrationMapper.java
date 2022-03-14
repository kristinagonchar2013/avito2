package com.amr.project.converter;

import com.amr.project.model.dto.RegistrationDto;

public interface RegistrationMapper {
     RegistrationDto MessageToRegistrationDTO(String message);
}
