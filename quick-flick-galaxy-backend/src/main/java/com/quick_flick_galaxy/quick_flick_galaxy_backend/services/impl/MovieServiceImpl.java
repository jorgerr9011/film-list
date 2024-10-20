package com.quick_flick_galaxy.quick_flick_galaxy_backend.services.impl;

import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.MovieModel;
import com.quick_flick_galaxy.quick_flick_galaxy_backend.repositories.IMovieRepository;
import com.quick_flick_galaxy.quick_flick_galaxy_backend.services.MovieService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    // Autowired sirve para inyección de dependencias
    @Autowired
    IMovieRepository movieRepository;

    public List<MovieModel> getMovies(){

        return (List<MovieModel>) movieRepository.findAll();
    }

    public List<MovieModel> saveMovies(List<MovieModel> movies) {

        return (List<MovieModel>) movieRepository.saveAll(movies);
    }

    public Optional<MovieModel> getMovieById(Long id) {

        return movieRepository.findById(id);
    }

    public MovieModel updateMovieById(MovieModel movieUpdated, Long id){
        Optional<MovieModel> optionalMovie = movieRepository.findById(id);

        if (optionalMovie.isPresent()) {
            MovieModel movie = optionalMovie.get();

            movie.setOverview(movieUpdated.getOverview());
            movie.setPopularity(movieUpdated.getPopularity());
            movie.setTitle(movieUpdated.getTitle());
            movie.setReleasedate(movieUpdated.getReleasedate());

            return movie;
        } else {
            throw new EntityNotFoundException("Movie with ID "+ id + " not found.");
        }
    }

    public Boolean deleteMovies() {
        try {
            movieRepository.deleteAll();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean deleteMovieById(Long id) {
        try {
            movieRepository.deleteById(id);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
