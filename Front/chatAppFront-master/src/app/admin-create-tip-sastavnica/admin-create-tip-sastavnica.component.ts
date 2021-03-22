import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {first} from 'rxjs/operators';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-admin-create-tip-sastavnica',
  templateUrl: './admin-create-tip-sastavnica.component.html',
  styleUrls: ['./admin-create-tip-sastavnica.component.css']
})
export class AdminCreateTipSastavnicaComponent implements OnInit {
  TipSastavnicaForm: FormGroup;
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.TipSastavnicaForm = this.formBuilder.group({
      nazivTs: ['']
    });
  }

  // tslint:disable-next-line:typedef
  create(){
    if (this.TipSastavnicaForm.value.nazivTs !== '') {
      this.adminService.registrujTipSastavnica(JSON.stringify(this.TipSastavnicaForm.value))
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
