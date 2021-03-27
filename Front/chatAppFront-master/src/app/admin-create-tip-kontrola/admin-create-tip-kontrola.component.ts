import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {OperaterServiceService} from '../services/operater-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {AdminServiceService} from '../services/admin-service.service';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-admin-create-tip-kontrola',
  templateUrl: './admin-create-tip-kontrola.component.html',
  styleUrls: ['./admin-create-tip-kontrola.component.css']
})
export class AdminCreateTipKontrolaComponent implements OnInit {
  TipKontrolaForm: FormGroup;
  tipOs: any = [];
  qsKontrole: any = [];
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal ) { }

  ngOnInit(): void {
    this.TipKontrolaForm = this.formBuilder.group({
      qsId: [''],
      tosId: ['']
    });
    this.ucitajTipoveOs();
    this.ucitajQsKontrole();
  }

  // tslint:disable-next-line:typedef
  ucitajQsKontrole() {
    this.adminService.getQsKontrole()
      .pipe(first())
      .subscribe(data => {
        this.qsKontrole = data;
      });
  }

  // tslint:disable-next-line:typedef
  ucitajTipoveOs() {
    this.adminService.getTipoviOs()
      .pipe(first())
      .subscribe(data => {
        this.tipOs = data;
      });
  }

  // tslint:disable-next-line:typedef
  create(){
    this.adminService.registrujTipKontrola(JSON.stringify(this.TipKontrolaForm.value))
      .pipe(first())
      .subscribe();
    this.router.navigate(['/admin/tipKontrolaAdmin']);
  }
  // tslint:disable-next-line:typedef
  MakeVote() {
    this.router.navigate(['/admin/tipKontrolaAdmin']);
  }

}
