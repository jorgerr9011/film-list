package com.quick_flick_galaxy.quick_flick_galaxy_backend.services;

import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.TvShowModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface TvShowService {

    List<TvShowModel> getTvShows();

    List<TvShowModel> saveTvShows(List<TvShowModel> tvShows);

    Optional<TvShowModel> getTvShowById(Long id);

    TvShowModel updateTvShowById(TvShowModel tvShowUpdated, Long id);

    Boolean deleteTvShows();

    Boolean deleteTvShowById(Long id);
}
