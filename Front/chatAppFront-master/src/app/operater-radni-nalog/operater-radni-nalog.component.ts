import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {OperaterServiceService} from '../services/operater-service.service';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-operater-radni-nalog',
  templateUrl: './operater-radni-nalog.component.html',
  styleUrls: ['./operater-radni-nalog.component.css']
})
export class OperaterRadniNalogComponent implements OnInit {
  radniNalozi: any = [];
  pogoni: any = [];
  kancelarije: any = [];
  closeResult: string;
  RadniNalogForm: FormGroup;

  radniNalog: any = [];
  stavkeRN: any = [];


  stavkaRN: any = [];
  stavkeSas: any = [];
  stavkaSas: any = [];
  stanja: any = [];
  constructor(private router: Router, private operaterService: OperaterServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.ucitajRadneNaloge();
    this.ucitajPogone();
    this.ucitajKancelarije();
  }

  // tslint:disable-next-line:typedef
  ucitajRadneNaloge() {
    this.operaterService.getRadneNaloge()
      .pipe(first())
      .subscribe(data => {
        this.radniNalozi = data;
      });
  }

  // tslint:disable-next-line:typedef
  ucitajPogone() {
    this.operaterService.getPogone()
      .pipe(first())
      .subscribe(data => {
        this.pogoni = data;
      });
  }

  // tslint:disable-next-line:typedef
  ucitajKancelarije() {
    this.operaterService.getKancelarijas()
      .pipe(first())
      .subscribe(data => {
        this.kancelarije = data;
      });
  }

  // tslint:disable-next-line:typedef
  logout() {
    localStorage.removeItem('currentuser');
    this.router.navigate(['/']);

  }

  // tslint:disable-next-line:typedef
  otvoriStavke(openCom, radniNalog){
    this.radniNalog = radniNalog;
    this.stavkeRN = [];
    this.ucitajStavkuRN();

    this.modalService.open(openCom, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  // tslint:disable-next-line:typedef
  ucitajStavkuRN() {
    this.operaterService.getStavkaRN(this.radniNalog.rnId)
      .pipe(first())
      .subscribe(data => {
        this.stavkeRN = data;
      });
  }

  // tslint:disable-next-line:typedef
  otvoriStavkeSas(openCom, stavkaRN){
    this.stavkaRN = stavkaRN;
    this.stavkeSas = [];
    this.stavkeSas = stavkaRN.stavka_sasSet;

    this.modalService.open(openCom, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  // tslint:disable-next-line:typedef
  prikaziTrebovano(openCom, stavkaSas){
    this.stavkaSas = stavkaSas;
    this.stanja = this.stavkaSas.stanjeSet;

    this.modalService.open(openCom, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

}
