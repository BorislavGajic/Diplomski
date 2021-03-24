import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {OperaterServiceService} from '../services/operater-service.service';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-operater-create-test',
  templateUrl: './operater-create-test.component.html',
  styleUrls: ['./operater-create-test.component.css']
})
export class OperaterCreateTestComponent implements OnInit {
  TestForm: FormGroup;
  osiguraci: any = [];
  testLinije: any = [];
  reparacije: any = [];
  constructor(private router: Router, private operaterService: OperaterServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.TestForm = this.formBuilder.group({
      tlId: [''],
      tosId: [''],
      nazTest: [''],
      reId: [''],
      osId: [''],
      osigurac: ['']
    });
    this.ucitajOsigurace();
    this.ucitajTestLinije();
    this.ucitajReparacije();
  }

  // tslint:disable-next-line:typedef
  ucitajOsigurace() {
    this.operaterService.getOsiguraci()
      .pipe(first())
      .subscribe(data => {
        this.osiguraci = data;
      });
  }

  // tslint:disable-next-line:typedef
  ucitajTestLinije() {
    this.operaterService.getTestLinije()
      .pipe(first())
      .subscribe(data => {
        this.testLinije = data;
      });
  }

  // tslint:disable-next-line:typedef
  ucitajReparacije() {
    this.operaterService.getReparacije()
      .pipe(first())
      .subscribe(data => {
        this.reparacije = data;
      });
  }

  // tslint:disable-next-line:typedef
  create(){
    this.TestForm.value.tosId = this.TestForm.value.osigurac.tosId.tosId;
    this.TestForm.value.osId = this.TestForm.value.osigurac.osId;
    console.log(this.TestForm.value);
    this.operaterService.registrujTest(JSON.stringify(this.TestForm.value))
          .pipe(first())
          .subscribe();
    this.router.navigate(['/operater/operaterTest']);
  }
  // tslint:disable-next-line:typedef
  MakeVote() {
    this.router.navigate(['/operater/operaterTest']);
  }

}
