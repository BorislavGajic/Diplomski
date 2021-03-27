import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-admin-tip-test',
  templateUrl: './admin-tip-test.component.html',
  styleUrls: ['./admin-tip-test.component.css']
})
export class AdminTipTestComponent implements OnInit {
  tipoviTestova: any = [];
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.ucitajTipoveTestova();
  }

  // tslint:disable-next-line:typedef
  logout() {
    localStorage.removeItem('currentuser');
    this.router.navigate(['/']);

  }

  // tslint:disable-next-line:typedef
  ucitajTipoveTestova() {
    this.adminService.getTipoviTestova()
      .pipe(first())
      .subscribe(data => {
        this.tipoviTestova = data;
      });
  }

  // tslint:disable-next-line:typedef
  delete(tipTesta) {
    this.adminService.deleteTipTest(tipTesta.tipTestKey.tlId, tipTesta.tipTestKey.tosId)
      .pipe(first())
      .subscribe();
    this.ucitajTipoveTestova();
  }

  // tslint:disable-next-line:typedef
  MakeVote(){
    this.router.navigate(['/createTipTest']);
  }

}
