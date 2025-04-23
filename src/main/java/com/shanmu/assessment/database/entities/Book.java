package com.shanmu.assessment.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "books")
public class Book extends BaseEntity {
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    private Date publishedYear;
    private Long availableCopies;
}
