package com.test.jpa.mavenTest.service;

import com.test.jpa.mavenTest.dto.ItemDto;
import com.test.jpa.mavenTest.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    //전체 제품조회
    public List<ItemDto> itemList() {
        return itemRepository.findAllByDtypeList();
    }

    //도서 제품조회
    public List<ItemDto> bookList() {
        return itemRepository.findAllByBookList();
    }

    //음악 제품조회
    public List<ItemDto> albumList() {
        return itemRepository.findAllByAlbumList();
    }

    //영화 제품조회
    public List<ItemDto> movieList() {
        return itemRepository.findAllByMovieList();
    }
}
