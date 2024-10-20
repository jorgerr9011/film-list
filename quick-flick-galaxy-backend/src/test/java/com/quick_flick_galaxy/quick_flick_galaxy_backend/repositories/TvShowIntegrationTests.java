package com.quick_flick_galaxy.quick_flick_galaxy_backend.repositories;

import com.quick_flick_galaxy.quick_flick_galaxy_backend.models.TvShowModel;
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
public class TvShowIntegrationTests {

    @Autowired
    private ITvShowRepository TvShowRepositoryTest;

    public TvShowModel setTvShow(){
        TvShowModel tvShow = new TvShowModel();

        tvShow.setId(1L);
        tvShow.setTitle("Test 1");
        tvShow.setOverview("Overview test");
        tvShow.setPopularity(2.22);
        tvShow.setReleasedate(LocalDate.now());

        return tvShow;
    }

    @Test
    public void testTvShowCreatedAndDeleted() {
        TvShowModel tvShowTest = setTvShow();

        TvShowRepositoryTest.save(tvShowTest);

        Optional<TvShowModel> savedTvShow = TvShowRepositoryTest.findById(tvShowTest.getId());

        assertThat(savedTvShow).isPresent();

        /* Es necesario obtener la Movie con get() para poder
         * compararla con la Movie previamente creada */
        assertThat(savedTvShow.get()).isEqualTo(tvShowTest);
    }

    @Test
    public void testFindAllTvShows() {

    }

    @Test
    public void testUpdateTvShows() {

    }

    @Test
    public void testRemoveTvShows() {

    }
}
