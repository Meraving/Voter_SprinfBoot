package com.githab.meraving.voter.service.impl;

import com.githab.meraving.voter.dto.CreateUserDto;
import com.githab.meraving.voter.dto.UpdateUserDto;
import com.githab.meraving.voter.dto.UserDto;
import com.githab.meraving.voter.model.User;
import com.githab.meraving.voter.repository.UserRepository;
import com.githab.meraving.voter.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static com.githab.meraving.voter.util.UserUtil.convertRolesToAuthorities;
import static com.githab.meraving.voter.util.ValidationUtil.getFromOptional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserDto create(CreateUserDto createUserDto) {
        Assert.notNull(createUserDto, "user must not be null");
        User user = User.of(createUserDto);
        return UserDto.of(repository.save(user));
    }

    @Override
    public UserDto get(Long id) {
        return UserDto.of(getFromOptional(repository.findById(id)));
    }

    @Override
    public UserDto update(Long id, UpdateUserDto updateUserDto) {
        Assert.notNull(updateUserDto, "user must not be null");
        User user = getFromOptional(repository.findById(id));
        user.setName(updateUserDto.getName());
        user.setPassword(updateUserDto.getPassword());
        return UserDto.of(repository.save(user));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserDto getByName(String name) {
        Assert.notNull(name, "name must not be null");
        return UserDto.of(getFromOptional(repository.getByName(name)));
    }

    @Override
    public List<UserDto> getAll() {
        return repository.findAll().stream().map(UserDto::of).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.getByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Can`t find user " + username));
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), convertRolesToAuthorities(user.getRoles()));
    }
}
