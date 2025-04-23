package com.shanmu.assessment.service;

import com.shanmu.assessment.database.entities.Book;
import com.shanmu.assessment.database.repositories.BookRepository;
import com.shanmu.assessment.dto.books.BookDto;
import com.shanmu.assessment.dto.books.GetBookDto;
import com.shanmu.assessment.dto.filters.BookFilterDto;
import com.shanmu.assessment.dto.filters.PaginatedResponse;
import com.shanmu.assessment.service.interfaces.IBookService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BookService(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public GetBookDto addBook(BookDto bookDto) {
        Book book = modelMapper.map(bookDto, Book.class);
        Book savedBook = bookRepository.save(book);

        return modelMapper.map(savedBook, GetBookDto.class);
    }

    @Override
    public List<GetBookDto> getAllBooks() {
        List<Book> dbBooks =  bookRepository.findAll();
        List<GetBookDto> books = dbBooks.stream()
                .map(book -> modelMapper.map(book, GetBookDto.class))
                .toList();

        return books;
    }

    @Override
    public GetBookDto getBookById(Long id) {
        Optional<Book> dbBooks = bookRepository.findById(id);
        if (dbBooks.isEmpty()) {
            // TODO
        }

        return modelMapper.map(dbBooks, GetBookDto.class);
    }

    @Override
    public GetBookDto updateBook(BookDto bookDto, Long id) {
        Optional<Book> dbBook = bookRepository.findById(id);

        if (dbBook.isEmpty()) {
            // TODO
        }

        Book existingBook = dbBook.get();
        modelMapper.map(bookDto, existingBook);
        Book updatedBook =  bookRepository.save(existingBook);

        return modelMapper.map(updatedBook, GetBookDto.class);
    }

    @Override
    public boolean deleteBook(Long id) {
        Optional<Book> dbBook = bookRepository.findById(id);

        if (dbBook.isEmpty()) {
            // TODO
        }

        Book existingBook = dbBook.get();
        bookRepository.delete(existingBook);

        return true; //TODO: fix
    }

    @Override
    public PaginatedResponse<GetBookDto> searchBooks(BookFilterDto filter, int page, int size) {
        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(Sort.Direction.fromString(filter.getDirection()), filter.getSortBy())
        );

        Page<Book> books = bookRepository.findBooksByFilters(
                filter.getAuthorId(),
                filter.getAuthorName(),
                filter.getPublishedYear(),
                pageable
        );

        List<GetBookDto> bookDtos = books.stream()
                .map(book -> modelMapper.map(book, GetBookDto.class))
                .toList();

        PaginatedResponse<GetBookDto> response = new PaginatedResponse();
        response.setData(bookDtos);
        response.setTotalItems((int)books.getTotalElements());
        response.setCurrentPage(page);
        response.setTotalPages(books.getTotalPages());

        return response;
    }

    @Override
    public PaginatedResponse<GetBookDto> getPaginatedBooks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Book> books = bookRepository.findAll(pageable);
        List<GetBookDto> bookDtos = books.stream()
                .map(book -> modelMapper.map(book, GetBookDto.class))
                .toList();

        PaginatedResponse<GetBookDto> response = new PaginatedResponse();
        response.setData(bookDtos);
        response.setTotalItems((int)books.getTotalElements());
        response.setCurrentPage(page);
        response.setTotalPages(books.getTotalPages());

        return response;
    }
}
