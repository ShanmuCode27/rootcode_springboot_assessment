package com.shanmu.assessment.dto.users;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateUserDto {
    private String name;
    private String email;
}
