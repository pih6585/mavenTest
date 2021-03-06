package com.test.jpa.mavenTest.entity.itemTable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("Book")
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Book extends Item {

    private String author;

    private String isbn;

    public static Book bookCreate(String author, String isbn, String name, int price, int stockQuantity) {
        Book book = new Book(null,author,isbn,name,price,stockQuantity);
        return book;
    }

    public static Book bookUpdate(Long id, String author, String isbn, String name, int price, int stockQuantity) {
        Book book = new Book(id, author,isbn,name,price,stockQuantity);
        return book;
    }

    private Book(Long id, String author, String isbn, String name, int price, int stockQuantity){
        this.author = author;
        this.isbn = isbn;
        if(id != null){
            this.setId(id);
        }
        this.setName(name);
        this.setPrice(price);
        this.setStockQuantity(stockQuantity);
    }
}
