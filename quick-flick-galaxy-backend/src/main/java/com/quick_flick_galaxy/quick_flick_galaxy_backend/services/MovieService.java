package com.quick_flick_galaxy.quick_flick_galaxy_backend.services;

import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.MovieModel;
import com.quick_flick_galaxy.quick_flick_galaxy_backend.repositories.IMovieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MovieService {

    // Autowired sirve para inyección de dependencias
    @Autowired
    IMovieRepository movieRepository;

    public ArrayList<MovieModel> getMovies(){

        return (ArrayList<MovieModel>) movieRepository.findAll();
    }

    public ArrayList<MovieModel> saveMovies(ArrayList<MovieModel> movies) {

        return (ArrayList<MovieModel>) movieRepository.saveAll(movies);
    }

    /*
        El optional sirve para que se pueda devolver o una Movie o un null
    * */
    public Optional<MovieModel> getMovieById(Long id){

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
