package com.quick_flick_galaxy.quick_flick_galaxy_backend.mappers.impl;

import com.quick_flick_galaxy.quick_flick_galaxy_backend.mappers.Mapper;
import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.MovieModel;
import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.dto.MovieDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/*
    Siempre que se trate de un Bean (Como en este caso, de config.MapperConfig),
    la clase tiene que llevar la anotación @Component
*/

@Component
public class MovieMapperImpl implements Mapper<MovieModel, MovieDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MovieDto mapTo(MovieModel movieModel) {
        return modelMapper.map(movieModel, MovieDto.class);
    }

    @Override
    public MovieModel mapFrom(MovieDto movieDto) {
        return modelMapper.map(movieDto, MovieModel.class);
    }

    @Override
    public Optional<MovieDto> mapTo(Optional<MovieModel> optionalMovieModel) {
        return Optional.ofNullable(modelMapper.map(optionalMovieModel, MovieDto.class));
    }

}
