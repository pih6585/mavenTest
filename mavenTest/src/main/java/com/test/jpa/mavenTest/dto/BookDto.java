package com.test.jpa.mavenTest.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.test.jpa.mavenTest.entity.itemTable.ItemDtype;
import lombok.Data;

@Data
public class BookDto extends ItemDto {

    private String author;

    private String isbn;

    public BookDto(){

    }

    public BookDto(String author, String isbn, String name, int price, int stockQuantity) {
        this.author = author;
        this.isbn = isbn;
        this.setName(name);
        this.setPrice(price);
        this.setStockQuantity(stockQuantity);
    }

    @QueryProjection
    public BookDto(Long id, String author, String isbn, String name, int price, int stockQuantity, ItemDtype itemDtype) {
        this.setId(id);
        this.author = author;
        this.isbn = isbn;
        this.setName(name);
        this.setPrice(price);
        this.setStockQuantity(stockQuantity);
        this.setItemDtype(itemDtype);
    }
}
