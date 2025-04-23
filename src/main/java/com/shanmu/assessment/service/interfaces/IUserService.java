package com.shanmu.assessment.service.interfaces;

import com.shanmu.assessment.dto.users.GetUserDto;
import com.shanmu.assessment.dto.users.RegisterUserDto;
import com.shanmu.assessment.dto.users.UpdateUserDto;

import java.util.List;

public interface IUserService {
    GetUserDto registerUser(RegisterUserDto registerUserDto);
    List<GetUserDto> getAllUsers();
    GetUserDto getUserById(Long id);
    GetUserDto updateUser(UpdateUserDto updateUserDto, Long id);
    boolean deleteUser(Long id);
}
