package com.shanmu.assessment.dto.users;

import com.shanmu.assessment.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterUserDto {
    private String name;
    private String email;
    private String password;
    private Role role;
}
