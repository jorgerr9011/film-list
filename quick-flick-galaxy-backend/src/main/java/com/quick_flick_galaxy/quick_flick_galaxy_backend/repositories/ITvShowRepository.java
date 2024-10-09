package com.quick_flick_galaxy.quick_flick_galaxy_backend.repositories;

import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.TvShowModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITvShowRepository extends JpaRepository<TvShowModel, Long>  {
}
