package com.shanmu.assessment.service;

import com.shanmu.assessment.dto.books.BookDto;
import com.shanmu.assessment.dto.books.GetBookDto;
import com.shanmu.assessment.service.interfaces.IBookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Override
    public GetBookDto addBook(BookDto bookDto) {
        return null;
    }

    @Override
    public List<GetBookDto> getAllBooks() {
        return List.of();
    }

    @Override
    public GetBookDto getBookById(Long id) {
        return null;
    }

    @Override
    public GetBookDto updateBook(BookDto bookDto, Long id) {
        return null;
    }

    @Override
    public boolean deleteBook(Long id) {
        return false;
    }
}
