package com.quick_flick_galaxy.quick_flick_galaxy_backend.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tvshow")
public class TvShowModel {

    @Id
    private Long id;

    private String title;
    private String overview;
    private Double popularity;
    private LocalDate releasedate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public LocalDate getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(LocalDate releasedate) {
        this.releasedate = releasedate;
    }
}
