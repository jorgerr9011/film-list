package com.quick_flick_galaxy.quick_flick_galaxy_backend.controllers;

import com.quick_flick_galaxy.quick_flick_galaxy_backend.mappers.Mapper;
import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.MovieModel;
import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.dto.MovieDto;
import com.quick_flick_galaxy.quick_flick_galaxy_backend.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private Mapper<MovieModel, MovieDto> movieMapper;

    @GetMapping
    public List<MovieDto> getMovies(){

        List<MovieModel> moviesList = this.movieService.getMovies();

        return moviesList.stream()
                .map(movieMapper::mapTo)
                .collect(Collectors.toList());
    }

    @PostMapping
    public List<MovieDto> saveMovies(@RequestBody List<MovieDto> movies){

        List<MovieModel> moviesList = movies.stream()
                .map(movieMapper::mapFrom)
                .toList();

        List<MovieModel> result = this.movieService.saveMovies(moviesList);

        return result.stream()
                .map(movieMapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public Optional<MovieDto> getMovieById(@PathVariable Long id){

        Optional<MovieModel> movie = this.movieService.getMovieById(id);

        return movieMapper.mapTo(movie);
    }

    @PutMapping(path = "/{id}")
    public MovieDto updateMovieById(@RequestBody MovieDto movieUpdated, @PathVariable Long id){

        MovieModel movie = movieMapper.mapFrom(movieUpdated);
        MovieModel mUpdated = this.movieService.updateMovieById(movie, id);
        return movieMapper.mapTo(mUpdated);
    }

    @DeleteMapping
    public Boolean deleteMovies(){

        return this.movieService.deleteMovies();
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteMovieById(@PathVariable Long id){

        return this.movieService.deleteMovieById(id);
    }
}
