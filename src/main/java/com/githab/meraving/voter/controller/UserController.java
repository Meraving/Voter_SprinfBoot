package com.githab.meraving.voter.controller;

import com.githab.meraving.voter.dto.*;
import com.githab.meraving.voter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public UserDto createUser(@RequestBody @Valid CreateUserDto createUserDto) {
        return userService.create(createUserDto);
    }

    @GetMapping("/user/{id}")
    public UserDto get(@PathVariable("id") Long id) {
        return userService.get(id);
    }

    @PutMapping("/user/{id}")
    public UserDto updateUser(@PathVariable("id") Long id, @RequestBody @Valid UpdateUserDto updateUserDto) {
        return userService.update(id, updateUserDto);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @GetMapping("/users")
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/user/{name}")
    public UserDto getAll(@PathVariable("name") String name) {
        return userService.getByName(name);
    }


}
