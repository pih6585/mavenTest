package com.test.jpa.mavenTest.repository;

import com.test.jpa.mavenTest.entity.itemTable.Book;
import com.test.jpa.mavenTest.repository.query.BookRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long>, BookRepositoryQuery {

}
