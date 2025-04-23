package com.shanmu.assessment.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @NonNull
    private String name;
    @NonNull
    private String email;
    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
