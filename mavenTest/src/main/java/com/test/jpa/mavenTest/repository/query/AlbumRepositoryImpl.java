package com.test.jpa.mavenTest.repository.query;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.jpa.mavenTest.dto.AlbumDto;
import com.test.jpa.mavenTest.dto.QAlbumDto;

import javax.persistence.EntityManager;
import java.util.List;

import static com.test.jpa.mavenTest.entity.itemTable.QAlbum.album;

public class AlbumRepositoryImpl implements AlbumRepositoryQuery {

    private final EntityManager em;

    private final JPAQueryFactory queryFactory;

    public AlbumRepositoryImpl(EntityManager em) {
        this.em = em;
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public AlbumDto findByIdByDto(Long id) {
        AlbumDto albumDto = queryFactory
                .select(new QAlbumDto(album.id,album.artist,album.etc,album.name,album.price,album.stockQuantity,album.itemDtype))
                .from(album)
                .where(album.id.eq(id))
                .fetchOne();
        return albumDto;
    }

    @Override
    public List<AlbumDto> findByAllByDto() {
        List<AlbumDto> albumList = queryFactory
                .select(new QAlbumDto(album.id, album.artist, album.etc, album.name, album.price, album.stockQuantity, album.itemDtype))
                .from(album)
                .fetch();
        return albumList;
    }
}
