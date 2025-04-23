package com.shanmu.assessment.controller;

import com.shanmu.assessment.dto.auth.LoginRequestDto;
import com.shanmu.assessment.dto.users.GetUserDto;
import com.shanmu.assessment.dto.users.RegisterUserDto;
import com.shanmu.assessment.dto.users.UpdateUserDto;
import com.shanmu.assessment.service.interfaces.IUserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users")
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    // TODO: implement login for user

    @SecurityRequirement(name = "Authorization")
    @GetMapping
    public List<GetUserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    //TODO: paginated list

    @SecurityRequirement(name = "Authorization")
    @GetMapping(path = "{id}")
    public GetUserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping(path = "/register")
    public GetUserDto registerUser(@RequestBody RegisterUserDto registerUserDto) {
        return userService.registerUser(registerUserDto);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @SecurityRequirement(name = "Authorization")
    @PutMapping(path = "{id}")
    public GetUserDto updateUser(@RequestBody UpdateUserDto registerUserDto, @PathVariable Long id) {
        return userService.updateUser(registerUserDto, id);
    }

    @SecurityRequirement(name = "Authorization")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
