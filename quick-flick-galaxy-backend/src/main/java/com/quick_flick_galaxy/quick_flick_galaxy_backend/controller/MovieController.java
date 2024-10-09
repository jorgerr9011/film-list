package com.quick_flick_galaxy.quick_flick_galaxy_backend.controller;

import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.MovieModel;
import com.quick_flick_galaxy.quick_flick_galaxy_backend.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ArrayList<MovieModel> getMovies(){

        return this.movieService.getMovies();
    }

    @PostMapping
    public ArrayList<MovieModel> saveMovies(@RequestBody ArrayList<MovieModel> movies){

        return this.movieService.saveMovies(movies);
    }

    @GetMapping(path = "/{id}")
    public Optional<MovieModel> getMovieById(@PathVariable Long id){

        return this.movieService.getMovieById(id);
    }

    @PutMapping(path = "/{id}")
    public MovieModel updateMovieById(@RequestBody MovieModel movieUpdated, @PathVariable Long id){

        return this.movieService.updateMovieById(movieUpdated, id);
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteMovieById(@PathVariable Long id){

        return this.movieService.deleteMovieById(id);
    }
}
