import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {OperaterServiceService} from '../services/operater-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-operater-create-kontrola',
  templateUrl: './operater-create-kontrola.component.html',
  styleUrls: ['./operater-create-kontrola.component.css']
})
export class OperaterCreateKontrolaComponent implements OnInit {
  KontrolaForm: FormGroup;
  osiguraci: any = [];
  qsKontrole: any = [];
  reparacije: any = [];
  constructor(private router: Router, private operaterService: OperaterServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.KontrolaForm = this.formBuilder.group({
      qsId: [''],
      tosId: [''],
      nazKont: [''],
      reId: [''],
      osId: [''],
      osigurac: ['']
    });
    this.ucitajOsigurace();
    this.ucitajQsKontrole();
    this.ucitajReparacije();
  }

  // tslint:disable-next-line:typedef
  ucitajOsigurace() {
    this.operaterService.getOsiguraci()
      .pipe(first())
      .subscribe(data => {
        this.osiguraci = data;
        console.log(data);
      });
  }

  // tslint:disable-next-line:typedef
  ucitajQsKontrole() {
    this.operaterService.getQsKontrole()
      .pipe(first())
      .subscribe(data => {
        this.qsKontrole = data;
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
    this.KontrolaForm.value.tosId = this.KontrolaForm.value.osigurac.tosId.tosId;
    this.KontrolaForm.value.osId = this.KontrolaForm.value.osigurac.osId;
    console.log(this.KontrolaForm.value);
    this.operaterService.registrujKontrolu(JSON.stringify(this.KontrolaForm.value))
      .pipe(first())
      .subscribe();
    this.router.navigate(['/operater/operaterKontrola']);
  }
  // tslint:disable-next-line:typedef
  MakeVote() {
    this.router.navigate(['/operater/operaterKontrola']);
  }

}
