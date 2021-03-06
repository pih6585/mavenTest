package com.test.jpa.mavenTest.repository.query;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.jpa.mavenTest.dto.ItemDto;
import com.test.jpa.mavenTest.dto.QItemDto;
import com.test.jpa.mavenTest.entity.itemTable.ItemDtype;
import javax.persistence.EntityManager;
import java.util.List;
import static com.test.jpa.mavenTest.entity.itemTable.QItem.item;

public class ItemRepositoryImpl implements ItemRepositoryQuery {

    private final EntityManager em;

    private final JPAQueryFactory queryFactory;

    public ItemRepositoryImpl(EntityManager em) {
        this.em = em;
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ItemDto> findAllByDtypeList() {
        List<ItemDto> itemList = queryFactory
                .select(new QItemDto(item.id, item.name, item.price, item.stockQuantity, item.itemDtype,
                        item.itemDtype.when(ItemDtype.Book).then("도서")
                                .when(ItemDtype.Album).then("음악")
                                .when(ItemDtype.Movie).then("영화")
                                .otherwise("기타")
                ))
                .from(item)
                .fetch();

        return itemList;
    }

    @Override
    public List<ItemDto> findAllByBookList(){
        List<ItemDto> bookList = queryFactory
                .select(new QItemDto(item.id, item.name, item.price, item.stockQuantity, item.itemDtype,
                        item.itemDtype.when(ItemDtype.Book).then("도서")
                                .when(ItemDtype.Album).then("음악")
                                .when(ItemDtype.Movie).then("영화")
                                .otherwise("기타")
                ))
                .from(item)
                .where(item.itemDtype.eq(ItemDtype.Book))
                .fetch();
        return bookList;
    }

    @Override
    public List<ItemDto> findAllByAlbumList() {
        List<ItemDto> albumList = queryFactory
                .select(new QItemDto(item.id, item.name, item.price, item.stockQuantity, item.itemDtype,
                        item.itemDtype.when(ItemDtype.Book).then("도서")
                                .when(ItemDtype.Album).then("음악")
                                .when(ItemDtype.Movie).then("영화")
                                .otherwise("기타")
                ))
                .from(item)
                .where(item.itemDtype.eq(ItemDtype.Album))
                .fetch();
        return albumList;
    }

    @Override
    public List<ItemDto> findAllByMovieList() {
        List<ItemDto> movieList = queryFactory
                .select(new QItemDto(item.id, item.name, item.price, item.stockQuantity, item.itemDtype,
                        item.itemDtype.when(ItemDtype.Book).then("도서")
                                .when(ItemDtype.Album).then("음악")
                                .when(ItemDtype.Movie).then("영화")
                                .otherwise("기타")
                ))
                .from(item)
                .where(item.itemDtype.eq(ItemDtype.Movie))
                .fetch();
        return movieList;
    }
}
