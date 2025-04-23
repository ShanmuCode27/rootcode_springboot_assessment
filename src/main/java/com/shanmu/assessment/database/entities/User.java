package com.shanmu.assessment.database.entities;

import com.shanmu.assessment.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @OneToMany(mappedBy = "author")
    private List<Book> books;
    @Enumerated(EnumType.STRING)
    private Role role;
}
