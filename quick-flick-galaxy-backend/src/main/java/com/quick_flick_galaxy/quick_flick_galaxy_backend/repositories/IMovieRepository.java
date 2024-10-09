package com.quick_flick_galaxy.quick_flick_galaxy_backend.repositories;

import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends JpaRepository<MovieModel, Long> {

}
