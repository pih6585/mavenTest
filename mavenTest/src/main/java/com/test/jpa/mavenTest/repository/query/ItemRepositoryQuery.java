package com.test.jpa.mavenTest.repository.query;

import com.test.jpa.mavenTest.dto.ItemDto;

import java.util.List;

public interface ItemRepositoryQuery {
    List<ItemDto> findAllByDtypeList();
    List<ItemDto> findAllByBookList();
    List<ItemDto> findAllByAlbumList();
    List<ItemDto> findAllByMovieList();
}
