package com.quick_flick_galaxy.quick_flick_galaxy_backend.services;

import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.MovieModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<MovieModel> getMovies();

    List<MovieModel> saveMovies(List<MovieModel> movies);

    Optional<MovieModel> getMovieById(Long id);

    MovieModel updateMovieById(MovieModel movieUpdated, Long id);

    Boolean deleteMovies();

    Boolean deleteMovieById(Long id);
}
