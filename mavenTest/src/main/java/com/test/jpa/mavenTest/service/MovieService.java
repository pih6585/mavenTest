package com.test.jpa.mavenTest.service;

import com.test.jpa.mavenTest.dto.MovieDto;
import com.test.jpa.mavenTest.entity.itemTable.Movie;
import com.test.jpa.mavenTest.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    //영화저장
    @Transactional
    public Long movieCreate(MovieDto movieDto){
        Movie movie = Movie.movieCreate(movieDto.getDirector(),movieDto.getActor(), movieDto.getName(), movieDto.getPrice(), movieDto.getStockQuantity());
        Movie saveMovie = movieRepository.save(movie);
        return saveMovie.getId();
    }

    //영화_단일조회
    public MovieDto movieFindOne(Long id){
        MovieDto movieDto = movieRepository.findByOneByDto(id);
        return movieDto;
    }

    //영화_전체조회
    public List<MovieDto> movieFindAll(){
        List<MovieDto> movieList = movieRepository.findByAllByDto();
        return movieList;
    }

    //영화_수정
    @Transactional
    public Long movieUpdate(MovieDto movieDto) {
        Optional<Movie> optMovie = movieRepository.findById(movieDto.getId());
        Movie findMovie = Optional.ofNullable(optMovie.get()).get();
        Movie updateMovie = findMovie.movieUpdate(movieDto.getId(), movieDto.getDirector(), movieDto.getActor(), movieDto.getName(),
                movieDto.getPrice(), movieDto.getStockQuantity());
        Movie saveMovie = movieRepository.save(updateMovie);
        return saveMovie.getId();
    }
}
