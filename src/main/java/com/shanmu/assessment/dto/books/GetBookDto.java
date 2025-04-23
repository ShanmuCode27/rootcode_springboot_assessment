package com.shanmu.assessment.dto.books;

import com.shanmu.assessment.database.entities.User;
import com.shanmu.assessment.dto.users.GetAuthorDto;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class GetBookDto {
    private Long id;
    private String title;
    private GetAuthorDto author;
    private Date publishedYear;
    private Long availableCopies;
}
