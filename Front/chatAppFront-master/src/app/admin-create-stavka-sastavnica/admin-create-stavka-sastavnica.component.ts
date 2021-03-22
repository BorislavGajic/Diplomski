import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-admin-create-stavka-sastavnica',
  templateUrl: './admin-create-stavka-sastavnica.component.html',
  styleUrls: ['./admin-create-stavka-sastavnica.component.css']
})
export class AdminCreateStavkaSastavnicaComponent implements OnInit {
  sastavnica: any = [];
  SSForm: FormGroup;
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.SSForm = this.formBuilder.group({
      sId: [''],
      kolicinaSs: ['']
    });
  }

  // tslint:disable-next-line:typedef
  create(){
    this.sastavnica = this.adminService.getSastavnica();
    this.SSForm.value.sId = this.sastavnica.sId;
    if (this.SSForm.value.kolicinaSs !== '') {
      this.adminService.registrujStavkuSastavnice(JSON.stringify(this.SSForm.value))
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
  get formControls() { return this.SSForm.controls; }

}
