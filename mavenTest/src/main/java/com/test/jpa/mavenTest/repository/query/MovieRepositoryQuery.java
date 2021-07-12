package com.test.jpa.mavenTest.repository.query;

import com.test.jpa.mavenTest.dto.MovieDto;

import java.util.List;

public interface MovieRepositoryQuery {
    MovieDto findByOneByDto(Long id);
    List<MovieDto> findByAllByDto();

}
