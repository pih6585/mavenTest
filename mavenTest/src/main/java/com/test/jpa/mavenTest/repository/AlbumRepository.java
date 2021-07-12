package com.test.jpa.mavenTest.repository;


import com.test.jpa.mavenTest.entity.itemTable.Album;
import com.test.jpa.mavenTest.repository.query.AlbumRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long>, AlbumRepositoryQuery {

}
