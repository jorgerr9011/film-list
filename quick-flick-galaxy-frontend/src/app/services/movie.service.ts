import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private readonly url = 'http://localhost:8080/movie'
  http = inject(HttpClient)

  // Método para hacer una petición GET
  async getData(): Promise<Observable<any>> {
    return this.http.get<any>(this.url); 
  }
}
