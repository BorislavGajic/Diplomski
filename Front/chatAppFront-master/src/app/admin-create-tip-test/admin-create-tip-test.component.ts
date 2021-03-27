import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-admin-create-tip-test',
  templateUrl: './admin-create-tip-test.component.html',
  styleUrls: ['./admin-create-tip-test.component.css']
})
export class AdminCreateTipTestComponent implements OnInit {
  TipTestForm: FormGroup;
  tipOs: any = [];
  testLinije: any = [];
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.TipTestForm = this.formBuilder.group({
      tlId: [''],
      tosId: ['']
    });
    this.ucitajTipoveOs();
    this.ucitajTipoveTestLinije();
  }

  // tslint:disable-next-line:typedef
  ucitajTipoveTestLinije() {
    this.adminService.getTestLinije()
      .pipe(first())
      .subscribe(data => {
        this.testLinije = data;
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
    this.adminService.registrujTipTest(JSON.stringify(this.TipTestForm.value))
      .pipe(first())
      .subscribe();
    this.router.navigate(['/admin/tipTestaAdmin']);
  }
  // tslint:disable-next-line:typedef
  MakeVote() {
    this.router.navigate(['/admin/tipTestaAdmin']);
  }

}
