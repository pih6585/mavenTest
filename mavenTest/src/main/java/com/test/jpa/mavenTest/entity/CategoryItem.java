package com.test.jpa.mavenTest.entity;

import com.test.jpa.mavenTest.entity.itemTable.Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryItem {

    @Id
    @GeneratedValue
    @Column(name = "category_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;


    public static CategoryItem createCategoryItem(Category category, Item item) {
        CategoryItem categoryItem = new CategoryItem();
        categoryItem.setCategory(category);
        categoryItem.setItem(item);
        category.getCategoryItems().add(categoryItem);
       //item.getCategoryItems().add(categoryItem);
        return categoryItem;
    }

}
