package com.quick_flick_galaxy.quick_flick_galaxy_backend.services.impl;

import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.TvShowModel;
import com.quick_flick_galaxy.quick_flick_galaxy_backend.repositories.ITvShowRepository;
import com.quick_flick_galaxy.quick_flick_galaxy_backend.services.TvShowService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TvShowServiceImpl implements TvShowService {

    @Autowired
    ITvShowRepository tvShowRepository;

    public List<TvShowModel> getTvShows(){

        return (List<TvShowModel>) tvShowRepository.findAll();
    }

    public List<TvShowModel> saveTvShows(List<TvShowModel> tvShows) {

        return (List<TvShowModel>) tvShowRepository.saveAll(tvShows);
    }

    public Optional<TvShowModel> getTvShowById(Long id){

        return tvShowRepository.findById(id);
    }

    public TvShowModel updateTvShowById(TvShowModel tvShowUpdated, Long id){
        Optional<TvShowModel> optionalTvShow = tvShowRepository.findById(id);

        if (optionalTvShow.isPresent()) {
            TvShowModel tvShow = optionalTvShow.get();

            tvShow.setOverview(tvShowUpdated.getOverview());
            tvShow.setPopularity(tvShowUpdated.getPopularity());
            tvShow.setTitle(tvShowUpdated.getTitle());
            tvShow.setReleasedate(tvShowUpdated.getReleasedate());

            return tvShow;
        } else {
            throw new EntityNotFoundException("Movie with ID "+ id + " not found.");
        }
    }

    public Boolean deleteTvShows() {
        try {
            tvShowRepository.deleteAll();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean deleteTvShowById(Long id){
        try {
            tvShowRepository.deleteById(id);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
