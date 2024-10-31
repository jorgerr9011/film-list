package com.quick_flick_galaxy.quick_flick_galaxy_backend.controllers;

import com.quick_flick_galaxy.quick_flick_galaxy_backend.mappers.Mapper;
import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.TvShowModel;
import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.dto.TvShowDto;
import com.quick_flick_galaxy.quick_flick_galaxy_backend.services.TvShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tvshow")
public class TvShowController {

    private final TvShowService tvShowService;

    private final Mapper<TvShowModel, TvShowDto> tvShowMapper;

    @Autowired
    public TvShowController(TvShowService tvShowService, Mapper<TvShowModel, TvShowDto> tvShowMapper){
        this.tvShowService = tvShowService;
        this.tvShowMapper = tvShowMapper;
    }

    @GetMapping
    public List<TvShowDto> getTvShows(){

        List<TvShowModel> tvShowList = this.tvShowService.getTvShows();

        return tvShowList.stream()
                .map(tvShowMapper::mapTo)
                .collect(Collectors.toList());
    }

    @PostMapping
    public List<TvShowDto> saveTvShows(@RequestBody List<TvShowDto> tvShows){

        List<TvShowModel> tvShowList = tvShows.stream()
                .map(tvShowMapper::mapFrom)
                .toList();

        List<TvShowModel> result = this.tvShowService.saveTvShows(tvShowList);

        return result.stream()
                .map(tvShowMapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public Optional<TvShowDto> getTvShowById(@PathVariable Long id){

        Optional<TvShowModel> tvShow = this.tvShowService.getTvShowById(id);
        return tvShowMapper.mapTo(tvShow);
    }

    @PutMapping(path = "/{id}")
    public TvShowDto updateTvShowById(@RequestBody TvShowDto tvShowUpdated, @PathVariable Long id){

        TvShowModel tvShow = tvShowMapper.mapFrom(tvShowUpdated);
        TvShowModel result = this.tvShowService.updateTvShowById(tvShow, id);

        return tvShowMapper.mapTo(result);
    }

    @DeleteMapping
    public Boolean deleteTvShows(){

        return this.tvShowService.deleteTvShows();
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteTvShowById(@PathVariable Long id){

        return this.tvShowService.deleteTvShowById(id);
    }
}
