import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {OperaterServiceService} from '../services/operater-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-operater-create-retest',
  templateUrl: './operater-create-retest.component.html',
  styleUrls: ['./operater-create-retest.component.css']
})
export class OperaterCreateRetestComponent implements OnInit {
  TestForm: FormGroup;
  reparacije: any = [];
  test: any = [];
  constructor(private router: Router, private operaterService: OperaterServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.TestForm = this.formBuilder.group({
      tlId: [''],
      tosId: [''],
      reId: ['']
    });
    this.ucitajReparacije();
    this.test = this.operaterService.gettTest();
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
    this.TestForm.value.tosId = this.test.testKey.tosId;
    this.TestForm.value.tlId = this.test.testKey.tlId;
    this.operaterService.putReTest(JSON.stringify(this.TestForm.value))
      .pipe(first())
      .subscribe();
    this.router.navigate(['/operater/operaterTest']);
  }
  // tslint:disable-next-line:typedef
  MakeVote() {
    this.router.navigate(['/operater/operaterTest']);
  }

}
