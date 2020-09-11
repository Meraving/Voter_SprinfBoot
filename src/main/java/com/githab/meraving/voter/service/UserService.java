package com.githab.meraving.voter.service;

import com.githab.meraving.voter.dto.CreateUserDto;
import com.githab.meraving.voter.dto.UpdateUserDto;
import com.githab.meraving.voter.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserDto create(CreateUserDto createUserDto);

    UserDto get(Long id);

    UserDto update(Long id, UpdateUserDto updateUserDto);

    void delete(Long id);

    UserDto getByName(String name);

    List<UserDto> getAll();
}
