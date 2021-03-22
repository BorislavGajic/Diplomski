import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-admin-create-sastavnica',
  templateUrl: './admin-create-sastavnica.component.html',
  styleUrls: ['./admin-create-sastavnica.component.css']
})
export class AdminCreateSastavnicaComponent implements OnInit {
  tipoviSastavnica: any = [];
  SastavnicaForm: FormGroup;
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.SastavnicaForm = this.formBuilder.group({
      tsId: ['']
    });
    this.ucitajTipoveSastavnice();
  }

  // tslint:disable-next-line:typedef
  ucitajTipoveSastavnice() {
    this.adminService.getTipSastavnica()
      .pipe(first())
      .subscribe(data => {
        this.tipoviSastavnica = data;
      });
  }

  // tslint:disable-next-line:typedef
  create(){
    if (this.SastavnicaForm.value.tsId !== '') {
      this.adminService.registrujSastavnicu(JSON.stringify(this.SastavnicaForm.value))
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

}
