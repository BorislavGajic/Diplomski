import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-admin-create-stavke-veza',
  templateUrl: './admin-create-stavke-veza.component.html',
  styleUrls: ['./admin-create-stavke-veza.component.css']
})
export class AdminCreateStavkeVezaComponent implements OnInit {
  stavkeSas: any = [];
  stavkaRN: any = [];
  VezaForm: FormGroup;

  selektovaneStavke: any = [];
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.ucitajRadneNaloge();

    this.VezaForm = this.formBuilder.group({
      sId: [''],
      sSasId: [''],
      rnId: [''],
      srnId: ['']
    });
  }

  // tslint:disable-next-line:typedef
  get formControls() { return this.VezaForm.controls; }

  // tslint:disable-next-line:typedef
  ucitajRadneNaloge() {
    this.adminService.getSveStavkeSas()
      .pipe(first())
      .subscribe(data => {
        this.stavkeSas = data;
      });
  }

  // tslint:disable-next-line:typedef
  create(){
    this.stavkaRN = this.adminService.gettStavkaRN();
    this.VezaForm.value.rnId = this.stavkaRN.stavka_rnKey.rnId;
    this.VezaForm.value.srnId = this.stavkaRN.stavka_rnKey.srnId;
    if (this.VezaForm.value.sId !== '' || this.VezaForm.value.ssId !== '') {
      this.adminService.dodajVezu(JSON.stringify(this.VezaForm.value), this.stavkaRN.stavka_rnKey.rnId, this.stavkaRN.stavka_rnKey.srnId )
        .pipe(first())
        .subscribe();
      this.router.navigate(['/admin/radniNalogAdmin']);
    }
    else{
      this.modalService.open('Polja nisu popunjena');
    }
  }
  // tslint:disable-next-line:typedef
  MakeVote() {
    this.router.navigate(['/admin/radniNalogAdmin']);
  }

  // tslint:disable-next-line:typedef
  someMethod(value) {
    this.adminService.getStavkaSas(value)
      .pipe(first())
      .subscribe(data => {
        this.selektovaneStavke = data;
      });
  }

}
