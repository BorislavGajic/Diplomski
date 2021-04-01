import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {OperaterServiceService} from '../services/operater-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-operater-create-rekon',
  templateUrl: './operater-create-rekon.component.html',
  styleUrls: ['./operater-create-rekon.component.css']
})
export class OperaterCreateRekonComponent implements OnInit {
  KontrolaForm: FormGroup;
  reparacije: any = [];
  kontrola: any = [];
  constructor(private router: Router, private operaterService: OperaterServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.KontrolaForm = this.formBuilder.group({
      kontrolaId: [''],
      qsId: [''],
      tosId: [''],
      reId: ['']
    });
    this.ucitajReparacije();
    this.kontrola = this.operaterService.gettKontrola();
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
    this.KontrolaForm.value.tosId = this.kontrola.tip_kontrola.tosId.tosId;
    this.KontrolaForm.value.qsId = this.kontrola.tip_kontrola.qsId.tosId;
    this.KontrolaForm.value.kontrolaId = this.kontrola.kontrolaId;
    this.operaterService.putReKont(JSON.stringify(this.KontrolaForm.value))
      .pipe(first())
      .subscribe();
    this.router.navigate(['/operater/operaterKontrola']);
  }
  // tslint:disable-next-line:typedef
  MakeVote() {
    this.router.navigate(['/operater/operaterKontrola']);
  }

}
