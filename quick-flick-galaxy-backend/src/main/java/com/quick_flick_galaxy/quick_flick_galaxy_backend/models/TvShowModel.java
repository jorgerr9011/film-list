package com.quick_flick_galaxy.quick_flick_galaxy_backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

/*
    Las siguientes anotaciones son de lombok.*
    que nos permite evitar codigo repetitivo como
    getters y setters
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tvshow")
public class TvShowModel {

    @Id
    private Long id;

    private String title;

    /*
        La anotacion @Lob le especifica a JPA que el
        contenido debe ser tratado como un "Large Object"
    */
    @Lob
    @Column(columnDefinition = "TEXT")
    private String overview;
    private Double popularity;

    /* Cada vez que un objeto se convierta a JSON, se
     * le dará el nombre específicado en vez de el nombre
     * del objeto de Java */
    //@JsonProperty("releaseDate")
    private LocalDate releasedate;
    private String poster;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TvShowModel that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(overview, that.overview) && Objects.equals(popularity, that.popularity) && Objects.equals(releasedate, that.releasedate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, overview, popularity, releasedate);
    }
}
