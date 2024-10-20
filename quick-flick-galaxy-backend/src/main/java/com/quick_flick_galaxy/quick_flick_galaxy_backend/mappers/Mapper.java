package com.quick_flick_galaxy.quick_flick_galaxy_backend.mappers;

import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.MovieModel;

import java.util.ArrayList;
import java.util.Optional;

public interface Mapper<A, B> {

    B mapTo(A a);

    A mapFrom(B b);

    Optional<B> mapTo(Optional<A> movie);
}
