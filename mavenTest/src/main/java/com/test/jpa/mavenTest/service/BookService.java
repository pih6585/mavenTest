package com.test.jpa.mavenTest.service;

import com.test.jpa.mavenTest.dto.BookDto;
import com.test.jpa.mavenTest.entity.itemTable.Book;
import com.test.jpa.mavenTest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookService {

    @Autowired
    BookRepository bookRepository;

    //도서_저장
    @Transactional
    public Long bookCreate(BookDto bookDto){
        Book book = Book.bookCreate(bookDto.getAuthor(),bookDto.getIsbn(),bookDto.getName(),bookDto.getPrice(),bookDto.getStockQuantity());
        Book saveBook = bookRepository.save(book);
        return saveBook.getId();
    }

    //도서_단일조회
    public BookDto bookFindOne(Long id){
        BookDto bookDto = bookRepository.findByOneByDto(id);
        return bookDto;
    }

    //도서_전체조회
    public List<BookDto> bookFindAll(){
        List<BookDto> booktDtoList = bookRepository.findByAllByDto();
        return booktDtoList;
    }


    //도서_수정
    @Transactional
    public Long bookUpdate(BookDto bookDto) {
        Optional<Book> optBook = bookRepository.findById(bookDto.getId());
        Book findBook = Optional.ofNullable(optBook.get()).get();
        Book updateBook = findBook.bookUpdate(bookDto.getId(), bookDto.getAuthor(), bookDto.getIsbn(), bookDto.getName(),
                                              bookDto.getPrice(), bookDto.getStockQuantity());
        Book saveBook = bookRepository.save(updateBook);
        return saveBook.getId();
    }
}
