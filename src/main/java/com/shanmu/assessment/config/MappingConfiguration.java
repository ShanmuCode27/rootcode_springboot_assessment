package com.shanmu.assessment.config;

import com.shanmu.assessment.database.entities.Book;
import com.shanmu.assessment.database.entities.User;
import com.shanmu.assessment.dto.books.BookDto;
import com.shanmu.assessment.dto.users.GetAuthorDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class MappingConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(User.class, GetAuthorDto.class);

        // Skipping author being set by mapper to fix error
        modelMapper.typeMap(BookDto.class, Book.class).addMappings(mapper -> {
            mapper.skip(Book::setAuthor);
        });

        return modelMapper;
    }
}
