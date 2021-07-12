package com.test.jpa.mavenTest.repository;

import com.test.jpa.mavenTest.entity.itemTable.Item;
import com.test.jpa.mavenTest.repository.query.ItemRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>, ItemRepositoryQuery {

}
