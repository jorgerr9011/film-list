package com.quick_flick_galaxy.quick_flick_galaxy_backend.controller;

import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.MovieModel;
import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.TvShowModel;
import com.quick_flick_galaxy.quick_flick_galaxy_backend.services.TvShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/tvshow")
public class TvShowController {

    @Autowired
    private TvShowService tvShowService;

    @GetMapping
    public ArrayList<TvShowModel> getTvShows(){

        return this.tvShowService.getTvShows();
    }

    @PostMapping
    public ArrayList<TvShowModel> saveTvShows(@RequestBody ArrayList<TvShowModel> tvShows){

        return this.tvShowService.saveTvShows(tvShows);
    }

    @GetMapping(path = "/{id}")
    public Optional<TvShowModel> getTvShowById(@PathVariable Long id){

        return this.tvShowService.getTvShowById(id);
    }

    @PutMapping(path = "/{id}")
    public TvShowModel updateTvShowById(@RequestBody TvShowModel movieUpdated, @PathVariable Long id){

        return this.tvShowService.updateTvShowById(movieUpdated, id);
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteTvShowById(@PathVariable Long id){

        return this.tvShowService.deleteTvShowById(id);
    }
}
