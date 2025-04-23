package com.shanmu.assessment.controller;

import com.shanmu.assessment.dto.books.BookDto;
import com.shanmu.assessment.dto.books.GetBookDto;
import com.shanmu.assessment.service.interfaces.IBookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "books")
public class BookController {
    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<GetBookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(path = "{id}")
    public GetBookDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public GetBookDto addBook(@RequestBody BookDto bookDto) {
        return bookService.addBook(bookDto);
    }

    @PutMapping(path = "{id}")
    public GetBookDto updateBook(@RequestBody BookDto bookDto, @PathVariable Long id) {
        return bookService.updateBook(bookDto, id);
    }

    @DeleteMapping(path = "{id}")
    public boolean deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }
}
