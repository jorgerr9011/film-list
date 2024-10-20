package com.quick_flick_galaxy.quick_flick_galaxy_backend.mappers.impl;

import com.quick_flick_galaxy.quick_flick_galaxy_backend.mappers.Mapper;
import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.TvShowModel;
import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.dto.TvShowDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/*
    Siempre que se trate de un Bean (Como en este caso, de config.MapperConfig),
    la clase tiene que llevar la anotación @Component
*/

@Component
public class TvShowMapperImpl implements Mapper<TvShowModel, TvShowDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TvShowDto mapTo(TvShowModel tvShowModel) {
        return modelMapper.map(tvShowModel, TvShowDto.class);
    }

    @Override
    public TvShowModel mapFrom(TvShowDto tvShowDto) {
        return modelMapper.map(tvShowDto, TvShowModel.class);
    }

    @Override
    public Optional<TvShowDto> mapTo(Optional<TvShowModel> optionalTvShowModel) {
        return Optional.ofNullable(modelMapper.map(optionalTvShowModel, TvShowDto.class));
    }
}
