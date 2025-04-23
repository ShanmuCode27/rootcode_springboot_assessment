package com.shanmu.assessment.service.interfaces;

import com.shanmu.assessment.dto.books.BookDto;
import com.shanmu.assessment.dto.books.GetBookDto;
import com.shanmu.assessment.dto.users.GetUserDto;
import com.shanmu.assessment.dto.users.RegisterUserDto;
import com.shanmu.assessment.dto.users.UpdateUserDto;

import java.util.List;

public interface IBookService {
    GetBookDto addBook(BookDto bookDto);
    List<GetBookDto> getAllBooks();
    GetBookDto getBookById(Long id);
    GetBookDto updateBook(BookDto bookDto, Long id);
    boolean deleteBook(Long id);
}
