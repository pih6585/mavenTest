package com.test.jpa.mavenTest.repository.query;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.jpa.mavenTest.dto.BookDto;
import com.test.jpa.mavenTest.dto.QBookDto;

import javax.persistence.EntityManager;
import java.util.List;

import static com.test.jpa.mavenTest.entity.itemTable.QBook.book;

public class BookRepositoryImpl implements  BookRepositoryQuery{

    private final EntityManager em;

    private final JPAQueryFactory queryFactory;

    public BookRepositoryImpl(EntityManager em) {
        this.em = em;
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public BookDto findByOneByDto(Long id) {
        BookDto bookDto = queryFactory
                .select(new QBookDto(book.id,book.author, book.isbn, book.name, book.price, book.stockQuantity, book.itemDtype))
                .from(book)
                .where(book.id.eq(id))
                .fetchOne();
        return bookDto;
    }

    @Override
    public List<BookDto> findByAllByDto() {
        List<BookDto> bookList = queryFactory
                .select(new QBookDto(book.id, book.author, book.isbn, book.name, book.price, book.stockQuantity, book.itemDtype))
                .from(book)
                .fetch();
        return bookList;
    }
}
