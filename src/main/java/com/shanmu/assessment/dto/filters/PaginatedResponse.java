package com.shanmu.assessment.dto.filters;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class PaginatedResponse<T> {
    private Integer totalItems;
    private Integer currentPage;
    private Integer totalPages;
    private List<T> data;
}
// TODO: setup builder