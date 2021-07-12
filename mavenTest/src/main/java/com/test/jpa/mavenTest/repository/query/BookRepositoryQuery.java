package com.test.jpa.mavenTest.repository.query;

import com.test.jpa.mavenTest.dto.BookDto;

import java.util.List;

public interface BookRepositoryQuery {
    BookDto findByOneByDto(Long id);
    List<BookDto> findByAllByDto();
}
