import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from '../models/movie/index';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private readonly url = 'http://localhost:8080/movie'
  http = inject(HttpClient)

  // Método para hacer una petición GET
  getData(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.url); 
  }
}
