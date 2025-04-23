package com.shanmu.assessment.dto.filters;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookFilterDto {
    private Long authorId;
    private String authorName;
    private Integer publishedYear;
    private String sortBy;
    private String direction = "asc";
}
