package com.amr.project.converter;

import com.amr.project.model.dto.UserDto;
import com.amr.project.model.entity.User;

public interface UserMapper {
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
}
