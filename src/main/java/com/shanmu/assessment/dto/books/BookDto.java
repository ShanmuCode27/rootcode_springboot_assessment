package com.shanmu.assessment.dto.books;

import com.shanmu.assessment.dto.users.GetAuthorDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class BookDto { // TODO: Could be split to Add and update as in future the fields needs to be updated could be minimized
    private String title;
    private GetAuthorDto author; // Assumption: On update the author is updatable, but could be forbidden if required
    private Date publishedYear;
    private Long availableCopies;
}
