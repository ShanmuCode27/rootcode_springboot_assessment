package com.shanmu.assessment.database.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "books")
public class Book extends BaseEntity {
    private String title;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author; // Assumption: Author has multiple books, each book is written by a single author
    private Date publishedYear;
    private Long availableCopies;
}
