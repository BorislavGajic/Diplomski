import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-admin-create-tip-multipola',
  templateUrl: './admin-create-tip-multipola.component.html',
  styleUrls: ['./admin-create-tip-multipola.component.css']
})
export class AdminCreateTipMultipolaComponent implements OnInit {
  tipoviOs: any = [];
  multipoli: any = [];
  TOMForm: FormGroup;
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.ucitajTipoveOS();
    this.ucitajMultipole();

    this.TOMForm = this.formBuilder.group({
      muId: [''],
      tosId: ['']
    });
  }

  // tslint:disable-next-line:typedef
  get formControls() { return this.TOMForm.controls; }

  // tslint:disable-next-line:typedef
  ucitajTipoveOS() {
    this.adminService.getTipoviOs()
      .pipe(first())
      .subscribe(data => {
        this.tipoviOs = data;
      });
  }

  // tslint:disable-next-line:typedef
  ucitajMultipole() {
    this.adminService.getMultipol()
      .pipe(first())
      .subscribe(data => {
        this.multipoli = data;
      });
  }

  // tslint:disable-next-line:typedef
  create(){
    if (this.TOMForm.value.muId !== '' || this.TOMForm.value.tosId !== '') {
      this.adminService.registrujTipMultipola(JSON.stringify(this.TOMForm.value))
        .pipe(first())
        .subscribe();
      this.router.navigate(['/admin/tipMultipolaAdmin']);
    }
    else{
      this.modalService.open('Polja nisu popunjena');
    }
  }
  // tslint:disable-next-line:typedef
  MakeVote() {
    this.router.navigate(['/admin/tipMultipolaAdmin']);
  }

}
