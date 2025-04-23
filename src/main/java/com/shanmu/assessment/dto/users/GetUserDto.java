package com.shanmu.assessment.dto.users;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetUserDto {
    private Long id;
    private String name;
    private String email;
}
