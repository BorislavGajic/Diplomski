import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-admin-create-ss-trebovanje',
  templateUrl: './admin-create-ss-trebovanje.component.html',
  styleUrls: ['./admin-create-ss-trebovanje.component.css']
})
export class AdminCreateSsTrebovanjeComponent implements OnInit {
  stanja: any = [];
  stavkaSas: any = [];
  TrebovanjeForm: FormGroup;
  selektovanaStanja: any = [];
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.TrebovanjeForm = this.formBuilder.group({
      sId: [''],
      ssId: [''],
      mId: [''],
      matId: ['']
    });
    this.ucitajStanja();
  }

  // tslint:disable-next-line:typedef
  ucitajStanja() {
    this.adminService.getStanja()
      .pipe(first())
      .subscribe(data => {
        this.stanja = data;
      });
  }

  // tslint:disable-next-line:typedef
  create(){
    this.stavkaSas = this.adminService.getStavkaSass();
    this.TrebovanjeForm.value.sId = this.stavkaSas.stavka_sasKey.sId;
    this.TrebovanjeForm.value.ssId = this.stavkaSas.stavka_sasKey.ssId;
    console.log(this.TrebovanjeForm.value);
    if (this.TrebovanjeForm.value.mId !== '' && this.TrebovanjeForm.value.matId !== '') {
      this.adminService.dodajTrebovanje(JSON.stringify(this.TrebovanjeForm.value), this.TrebovanjeForm.value.sId,
        this.TrebovanjeForm.value.ssId)
        .pipe(first())
        .subscribe();
      this.router.navigate(['/admin/sastavnicaAdmin']);
    }
    else{
      this.modalService.open('Polja nisu popunjena');
    }

  }
  // tslint:disable-next-line:typedef
  MakeVote() {
    this.router.navigate(['/admin/sastavnicaAdmin']);
  }

  // tslint:disable-next-line:typedef
  someMethod(value) {
    this.adminService.getStanjaPoMat(value)
      .pipe(first())
      .subscribe(data => {
        this.selektovanaStanja = data;
      });
  }

}
