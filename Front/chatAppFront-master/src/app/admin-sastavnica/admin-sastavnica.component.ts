import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {FormBuilder} from '@angular/forms';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-admin-sastavnica',
  templateUrl: './admin-sastavnica.component.html',
  styleUrls: ['./admin-sastavnica.component.css']
})
export class AdminSastavnicaComponent implements OnInit {
  sastavnice: any = [];
  sastavnica: any = [];
  stavkeSas: any = [];
  stavkaSas: any = [];
  closeResult: string;

  podsastavnice: any = [];
  stanja: any = [];
  popunjavanje: any = [];
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.ucitajSastavnice();
  }

  // tslint:disable-next-line:typedef
  logout() {
    localStorage.removeItem('currentuser');
    this.router.navigate(['/']);

  }
  // tslint:disable-next-line:typedef
  ucitajSastavnice() {
    this.adminService.getSastavnice()
      .pipe(first())
      .subscribe(data => {
        this.sastavnice = data;
      });
  }

  // tslint:disable-next-line:typedef
  delete(sastavnica) {
    this.adminService.deleteSastavnica(sastavnica.sId)
      .pipe(first())
      .subscribe();
    this.ucitajSastavnice();
  }

  // tslint:disable-next-line:typedef
  otvoriStavke(openCom, sastavnica){
    this.sastavnica = sastavnica;
    this.stavkeSas = [];
    this.ucitajStavkuSas();

    this.modalService.open(openCom, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  // tslint:disable-next-line:typedef
  ucitajStavkuSas() {
    this.adminService.getStavkaSas(this.sastavnica.sId)
      .pipe(first())
      .subscribe(data => {
        this.stavkeSas = data;
      });
  }

  // tslint:disable-next-line:typedef
  dodajStavku(sastavnica){
    this.sastavnica = sastavnica;
    this.adminService.setSastavnica(this.sastavnica);
    this.router.navigate(['/novaStavkaSastavnice']);
  }

  // tslint:disable-next-line:typedef
  MakeVote(){
    this.router.navigate(['/novaSastavnica']);
  }

  // tslint:disable-next-line:typedef
  MakeVote1(){
    this.router.navigate(['/noviTipSastavnica']);
  }

  // tslint:disable-next-line:typedef
  delete1(stavkaSas) {
    this.adminService.deleteStavkaSas(stavkaSas.stavka_sasKey.sId, stavkaSas.stavka_sasKey.ssId )
      .pipe(first())
      .subscribe();
    this.ucitajSastavnice();
  }

  // tslint:disable-next-line:typedef
  otvoriPodsastavnice(openCom, sastavnica){
    this.sastavnica = sastavnica;
    this.podsastavnice = this.sastavnica.sastavn1icaSet;

    this.modalService.open(openCom, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  // tslint:disable-next-line:typedef
  dodajPodsastavnicu(sastavnica){
    this.sastavnica = sastavnica;
    this.adminService.setSastavnica(sastavnica);
    this.router.navigate(['/novaPodsastavnica']);
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
  otvoriMaterijale(openCom, sastavnica){
    this.sastavnica = sastavnica;
    this.popunjavanje = this.sastavnica.materijalSet;
    console.log(this.sastavnica);

    this.modalService.open(openCom, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  // tslint:disable-next-line:typedef
  dodajMaterijal(sastavnica){
    this.sastavnica = sastavnica;
    this.adminService.setSastavnica(sastavnica);
    this.router.navigate(['/novoMaterijalSastavnica']);
    this.modalService.dismissAll();
  }

}
