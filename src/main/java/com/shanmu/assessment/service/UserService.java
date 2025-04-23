package com.shanmu.assessment.service;

import com.shanmu.assessment.database.entities.User;
import com.shanmu.assessment.database.repositories.UserRepository;
import com.shanmu.assessment.dto.users.GetUserDto;
import com.shanmu.assessment.dto.users.RegisterUserDto;
import com.shanmu.assessment.dto.users.UpdateUserDto;
import com.shanmu.assessment.service.interfaces.IUserService;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<GetUserDto> getAllUsers() {
        List<User> dbUsers =  userRepository.findAll();
        List<GetUserDto> users = dbUsers.stream()
                .map(user -> modelMapper.map(user, GetUserDto.class))
                .toList();

        return users;
    }

    @Override
    public GetUserDto getUserById(Long id) {
        Optional<User> dbUser = userRepository.findById(id);
        if (dbUser.isEmpty()) {
            // TODO
        }

        return modelMapper.map(dbUser, GetUserDto.class);
    }

    @Override
    public GetUserDto updateUser(UpdateUserDto updateUserDto, Long id) {
        Optional<User> dbUser = userRepository.findById(id);

        if (dbUser.isEmpty()) {
            // TODO
        }

        User existingUser = dbUser.get();
        modelMapper.map(updateUserDto, existingUser);
        User updatedUser =  userRepository.save(existingUser);

        return modelMapper.map(updatedUser, GetUserDto.class);
    }

    @Override
    public GetUserDto registerUser(RegisterUserDto registerUserDto) {
        User user = modelMapper.map(registerUserDto, User.class);
        User dbUser =  userRepository.save(user);

        return modelMapper.map(dbUser, GetUserDto.class);
    }

    @Override
    public boolean deleteUser(Long id) {
        Optional<User> dbUser = userRepository.findById(id);

        if (dbUser.isEmpty()) {
            // TODO
        }
        User existingUser = dbUser.get();
        userRepository.delete(existingUser);

        return true; //TODO: fix
    }
}
