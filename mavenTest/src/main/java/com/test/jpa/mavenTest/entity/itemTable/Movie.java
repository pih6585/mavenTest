package com.test.jpa.mavenTest.entity.itemTable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("Movie")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie extends Item {

    private String director;

    private String actor;


    public static Movie movieCreate(String director, String actor, String name, int price, int stockQuantity) {
        Movie movie = new Movie(null,director,actor,name,price,stockQuantity);
        return movie;
    }

    public static Movie movieUpdate(Long id, String director, String actor, String name, int price, int stockQuantity) {
        Movie movie = new Movie(id, director,actor,name,price,stockQuantity);
        return movie;
    }

    private Movie(Long id,String director, String actor, String name, int price, int stockQuantity){
        this.director = director;
        this.actor = actor;
        if(id != null){
            this.setId(id);
        }
        this.setName(name);
        this.setPrice(price);
        this.setStockQuantity(stockQuantity);
    }
}
