package com.test.jpa.mavenTest.repository;

import com.test.jpa.mavenTest.entity.itemTable.Movie;
import com.test.jpa.mavenTest.repository.query.MovieRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long>, MovieRepositoryQuery {
}
