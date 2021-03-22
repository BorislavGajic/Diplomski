import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-admin-radni-nalog',
  templateUrl: './admin-radni-nalog.component.html',
  styleUrls: ['./admin-radni-nalog.component.css']
})
export class AdminRadniNalogComponent implements OnInit {
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
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.ucitajRadneNaloge();
    this.ucitajPogone();
    this.ucitajKancelarije();

    this.RadniNalogForm = this.formBuilder.group({
      pogonPId: [''],
      kancelarijaKaId: ['']
    });
  }

  // tslint:disable-next-line:typedef
  ucitajRadneNaloge() {
    this.adminService.getRadneNaloge()
      .pipe(first())
      .subscribe(data => {
        this.radniNalozi = data;
      });
  }

  // tslint:disable-next-line:typedef
  ucitajPogone() {
    this.adminService.getPogone()
      .pipe(first())
      .subscribe(data => {
        this.pogoni = data;
      });
  }

  // tslint:disable-next-line:typedef
  ucitajKancelarije() {
    this.adminService.getKancelarijas()
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
  delete(radniNalog) {
    this.adminService.deleteRadniNalog(radniNalog.rnId)
      .pipe(first())
      .subscribe();
    this.ucitajRadneNaloge();
  }

  // tslint:disable-next-line:typedef
  get formControls() { return this.RadniNalogForm.controls; }

  // tslint:disable-next-line:typedef
  MakeVote(){
    this.router.navigate(['/noviRadniNalog']);
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
    this.adminService.getStavkaRN(this.radniNalog.rnId)
      .pipe(first())
      .subscribe(data => {
        this.stavkeRN = data;
      });
  }

  // tslint:disable-next-line:typedef
  dodajStavku(radniNalog){
    this.radniNalog = radniNalog;
    this.adminService.setRadniNalog(this.radniNalog);
    this.router.navigate(['/novaStavkaRN']);
  }

  // tslint:disable-next-line:typedef
  delete1(stavkaRN) {
    this.adminService.deleteStavkaRN(stavkaRN.rnId.rnId, stavkaRN.stavka_rnKey.srnId )
      .pipe(first())
      .subscribe();
    this.ucitajRadneNaloge();
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

  // tslint:disable-next-line:typedef
  dodajTrebovanje(stavkaSas){
    this.stavkaSas = stavkaSas;
    this.adminService.setSTavkaSas(stavkaSas);
    this.router.navigate(['/novoTrebovanjeSS']);
    this.modalService.dismissAll();
  }

  // tslint:disable-next-line:typedef
  dodajStavkuSas(stavkaRN){
    this.stavkaRN = stavkaRN;
    this.adminService.settStavkaRN(this.stavkaRN);
    this.router.navigate(['/novaStavkaVeza']);
    this.modalService.dismissAll();
  }
}
