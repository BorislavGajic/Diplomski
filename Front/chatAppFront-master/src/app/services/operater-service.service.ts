import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OperaterServiceService {

  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:typedef
  registrujOperatera(user) {
    return this.http.post('http://localhost:8090/operater', user,      {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
      responseType: 'text'
    });
  }

  // tslint:disable-next-line:typedef
  getTipoviOs() {
    return this.http.get('http://localhost:8090/tip_os',      {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    });
  }

  // tslint:disable-next-line:typedef
  getOsiguraci() {
    return this.http.get('http://localhost:8090/osigurac',      {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    });
  }

  // tslint:disable-next-line:typedef
  deleteOsigurac(id) {
    return this.http.delete('http://localhost:8090/osigurac/' + id,      {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
      responseType: 'text'
    });
  }
}
