import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class KorisnikServiceService {

  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:typedef
  registrujKorisnika(user) {
    return this.http.post('http://localhost:8090/korisnik', user,      {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
      responseType: 'text'
    });
  }
}
