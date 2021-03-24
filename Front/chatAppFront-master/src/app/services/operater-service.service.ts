import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OperaterServiceService {
  osigurac: any [];
  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:typedef
  settOsigurac(osigurac){
    this.osigurac = osigurac;
  }

  // tslint:disable-next-line:typedef
  gettOsigurac(){
    return this.osigurac;
  }

  // tslint:disable-next-line:typedef
  registrujOperatera(user) {
    return this.http.post('http://localhost:8090/operater', user,      {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
      responseType: 'text'
    });
  }

  // tslint:disable-next-line:typedef
  registrujOsigurac(user) {
    return this.http.post('http://localhost:8090/osigurac', user,      {
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

  // tslint:disable-next-line:typedef
  getMontaze() {
    return this.http.get('http://localhost:8090/montaza',      {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    });
  }

  // tslint:disable-next-line:typedef
  getRiveti() {
    return this.http.get('http://localhost:8090/rivet',      {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    });
  }

  // tslint:disable-next-line:typedef
  getPrintCentri() {
    return this.http.get('http://localhost:8090/print_centar',      {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    });
  }

  // tslint:disable-next-line:typedef
  getPakeraji() {
    return this.http.get('http://localhost:8090/pakeraj',      {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    });
  }

  // tslint:disable-next-line:typedef
  getMagacini() {
    return this.http.get('http://localhost:8090/magacin',      {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    });
  }

  // tslint:disable-next-line:typedef
  putMontaza(user) {
    return this.http.put('http://localhost:8090/osigurac/montaza', user,      {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
      responseType: 'text'
    });
  }

  // tslint:disable-next-line:typedef
  putRivet(user) {
    return this.http.put('http://localhost:8090/osigurac/rivet', user,      {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
      responseType: 'text'
    });
  }

  // tslint:disable-next-line:typedef
  putPrintCentar(user) {
    return this.http.put('http://localhost:8090/osigurac/print_centar', user,      {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
      responseType: 'text'
    });
  }

  // tslint:disable-next-line:typedef
  putMagacin(user) {
    return this.http.put('http://localhost:8090/osigurac/magacin', user,      {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
      responseType: 'text'
    });
  }

  // tslint:disable-next-line:typedef
  putPakeraj(user) {
    return this.http.put('http://localhost:8090/osigurac/pakeraj', user,      {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
      responseType: 'text'
    });
  }

  // tslint:disable-next-line:typedef
  putTipOsiguraca(user) {
    return this.http.put('http://localhost:8090/osigurac/tos', user,      {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
      responseType: 'text'
    });
  }

  // tslint:disable-next-line:typedef
  putTosMultipol(user) {
    return this.http.put('http://localhost:8090/osigurac/tos_multipol', user,      {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
      responseType: 'text'
    });
  }

  // tslint:disable-next-line:typedef
  getRadneNaloge() {
    return this.http.get('http://localhost:8090/radni_nalog',      {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    });
  }

  // tslint:disable-next-line:typedef
  getPogone() {
    return this.http.get('http://localhost:8090/pogon',      {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    });
  }

  // tslint:disable-next-line:typedef
  getKancelarijas() {
    return this.http.get('http://localhost:8090/kancelarija',      {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    });
  }

  // tslint:disable-next-line:typedef
  getStavkaRN(id) {
    return this.http.get('http://localhost:8090/stavka_rn/' + id,      {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    });
  }

  // tslint:disable-next-line:typedef
  getTestovi() {
    return this.http.get('http://localhost:8090/test',      {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    });
  }

  // tslint:disable-next-line:typedef
  deleteTest(id, id1) {
    return this.http.delete('http://localhost:8090/test/' + id + '/' + id1,      {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
      responseType: 'text'
    });
  }

  // tslint:disable-next-line:typedef
  getTestLinije() {
    return this.http.get('http://localhost:8090/test_linija',      {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    });
  }

  // tslint:disable-next-line:typedef
  getQsKontrole() {
    return this.http.get('http://localhost:8090/qs_kontrola',      {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    });
  }

  // tslint:disable-next-line:typedef
  registrujTest(user) {
    return this.http.post('http://localhost:8090/test', user,      {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
      responseType: 'text'
    });
  }

  // tslint:disable-next-line:typedef
  registrujKontrolu(user) {
    return this.http.post('http://localhost:8090/kontrola', user,      {
      headers: new HttpHeaders().set('Content-Type', 'application/json'),
      responseType: 'text'
    });
  }

  // tslint:disable-next-line:typedef
  getReparacije() {
    return this.http.get('http://localhost:8090/reparacija',      {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    });
  }

  // tslint:disable-next-line:typedef
  getKontrole() {
    return this.http.get('http://localhost:8090/kontrola',      {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    });
  }
}
