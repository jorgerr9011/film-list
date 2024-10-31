import { Component, inject, OnInit } from '@angular/core';
import { MovieService } from '../../services/movie.service';
import { CommonModule } from '@angular/common';
import { MovieComponent } from './movie-element/movie.component';

@Component({
  selector: 'app-movies',
  standalone: true,
  imports: [CommonModule, MovieComponent],
  templateUrl: './movies.component.html',
  styleUrl: './movies.component.css'
})
export class MoviesComponent implements OnInit {

  moviesData: any[] = [];
  movieService: MovieService = inject(MovieService);
  
  async ngOnInit() {
    this.movieService.getData().subscribe((data: any[]) => {
      this.moviesData = data;
    }, (error: any) => {
      console.error('Error fetching data:', error);
    });
  }

  /*constructor() {
    this.movieService.getData().then((data: any) => {
      this.moviesData = data;
    });
  }*/
}
