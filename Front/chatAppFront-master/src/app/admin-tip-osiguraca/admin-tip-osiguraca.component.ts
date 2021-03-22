import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {FormBuilder, FormGroup} from '@angular/forms';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-admin-tip-osiguraca',
  templateUrl: './admin-tip-osiguraca.component.html',
  styleUrls: ['./admin-tip-osiguraca.component.css']
})
export class AdminTipOsiguracaComponent implements OnInit {
  tipoviOs: any = [];
  closeResult: string;
  TipOsForm: FormGroup;
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.TipOsForm = this.formBuilder.group({
      brPolova: [''],
      nazTos: ['']
    });
    this.ucitajTipoveOs();
  }

  // tslint:disable-next-line:typedef
  logout() {
    localStorage.removeItem('currentuser');
    this.router.navigate(['/']);

  }

  // tslint:disable-next-line:typedef
  ucitajTipoveOs() {
    this.adminService.getTipoviOs()
      .pipe(first())
      .subscribe(data => {
        this.tipoviOs = data;
      });
  }

  // tslint:disable-next-line:typedef
  delete(tipOs) {
    this.adminService.deleteTOS(tipOs.tosId)
      .pipe(first())
      .subscribe();
    this.ucitajTipoveOs();
  }

  // tslint:disable-next-line:typedef
  get formControls() { return this.TipOsForm.controls; }

  // tslint:disable-next-line:typedef
  MakeVote(addVote){
    this.modalService.open(addVote, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  // tslint:disable-next-line:typedef
  create(){
    this.adminService.registrujTOS(JSON.stringify(this.TipOsForm.value))
      .pipe(first())
      .subscribe();
    this.ucitajTipoveOs();
    this.modalService.dismissAll();
  }

}
