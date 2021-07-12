package com.test.jpa.mavenTest.repository.query;

import com.test.jpa.mavenTest.dto.AlbumDto;

import java.util.List;

public interface AlbumRepositoryQuery {
    AlbumDto findByIdByDto(Long id);
    List<AlbumDto> findByAllByDto();
}
