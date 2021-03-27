import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {FormBuilder} from '@angular/forms';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-admin-tip-kontrola',
  templateUrl: './admin-tip-kontrola.component.html',
  styleUrls: ['./admin-tip-kontrola.component.css']
})
export class AdminTipKontrolaComponent implements OnInit {
  tipoviKontrola: any = [];
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.ucitajTipoveKontrola();
  }

  // tslint:disable-next-line:typedef
  logout() {
    localStorage.removeItem('currentuser');
    this.router.navigate(['/']);

  }

  // tslint:disable-next-line:typedef
  ucitajTipoveKontrola() {
    this.adminService.getTipKontrola()
      .pipe(first())
      .subscribe(data => {
        this.tipoviKontrola = data;
      });
  }

  // tslint:disable-next-line:typedef
  delete(tipKontrola) {
    this.adminService.deleteTipKontrola(tipKontrola.tipKontrolaKey.qsId, tipKontrola.tipKontrolaKey.tosId)
      .pipe(first())
      .subscribe();
    this.ucitajTipoveKontrola();
  }

  // tslint:disable-next-line:typedef
  MakeVote(){
    this.router.navigate(['/createTipKontrola']);
  }

}
