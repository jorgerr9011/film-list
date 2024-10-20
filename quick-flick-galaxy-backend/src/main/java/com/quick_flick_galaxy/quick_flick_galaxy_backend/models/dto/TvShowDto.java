package com.quick_flick_galaxy.quick_flick_galaxy_backend.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

/*
    Las siguientes anotaciones son de lombok.*
    que nos permite evitar codigo repetitivo como
    getters y setters
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TvShowDto {

    private Long id;

    private String title;
    private String overview;
    private Double popularity;
    private LocalDate releasedate;
}
