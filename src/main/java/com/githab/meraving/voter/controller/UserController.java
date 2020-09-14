package com.githab.meraving.voter.controller;

import com.githab.meraving.voter.dto.CreateUserDto;
import com.githab.meraving.voter.dto.UpdateUserDto;
import com.githab.meraving.voter.dto.UserDto;
import com.githab.meraving.voter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    @PreAuthorize("hasAnyAuthority('USER:WRITE')")
    public UserDto createUser(@RequestBody @Valid CreateUserDto createUserDto) {
        return userService.create(createUserDto);
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public UserDto get(@PathVariable("id") Long id) {
        return userService.get(id);
    }

    @PutMapping("/user/{id}")
    @PreAuthorize("hasAnyAuthority('USER:WRITE')")
    public UserDto updateUser(@PathVariable("id") Long id, @RequestBody @Valid UpdateUserDto updateUserDto) {
        return userService.update(id, updateUserDto);
    }

    @DeleteMapping("/user/{id}")
    @PreAuthorize("hasAnyAuthority('USER:WRITE')")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @GetMapping("/users")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/user/{name}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public UserDto getByName(@PathVariable("name") String name) {
        return userService.getByName(name);
    }
}
