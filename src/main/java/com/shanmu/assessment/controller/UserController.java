package com.shanmu.assessment.controller;

import com.shanmu.assessment.dto.users.GetUserDto;
import com.shanmu.assessment.dto.users.RegisterUserDto;
import com.shanmu.assessment.dto.users.UpdateUserDto;
import com.shanmu.assessment.service.interfaces.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users")
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<GetUserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "{id}")
    public GetUserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public GetUserDto registerUser(@RequestBody RegisterUserDto registerUserDto) {
        return userService.registerUser(registerUserDto);
    }

    @PutMapping(path = "{id}")
    public GetUserDto updateUser(@RequestBody UpdateUserDto registerUserDto, @PathVariable Long id) {
        return userService.updateUser(registerUserDto, id);
    }

    @DeleteMapping(path = "{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
