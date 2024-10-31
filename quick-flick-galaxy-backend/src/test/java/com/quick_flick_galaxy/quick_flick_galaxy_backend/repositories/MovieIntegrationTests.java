package com.quick_flick_galaxy.quick_flick_galaxy_backend.repositories;

import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.MovieModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MovieIntegrationTests {

    @Autowired
    private IMovieRepository movieRepositoryTest;

    public MovieModel setMovie() {
        MovieModel movie = new MovieModel();

        movie.setId(1L);
        movie.setTitle("Test 1");
        movie.setOverview("Overview test");
        movie.setPopularity(1.22);
        movie.setReleasedate(LocalDate.now());
        movie.setPoster("http://#");

        return movie;
    }

    @Test
    public void testMovieCreatedAndDeleted() {
        MovieModel movieTest = setMovie();

        movieRepositoryTest.save(movieTest);
        Optional<MovieModel> savedMovie = movieRepositoryTest.findById(movieTest.getId());
        assertThat(savedMovie).isPresent();

        /* Es necesario obtener la Movie con get() para poder
        * compararla con la Movie previamente creada */
        assertThat(savedMovie.get()).isEqualTo(movieTest);
    }

    @Test
    public void testFindAllMovies() {

    }

    @Test
    public void testUpdateMovie() {

    }

    @Test
    public void testRemoveMovie() {

    }
}
