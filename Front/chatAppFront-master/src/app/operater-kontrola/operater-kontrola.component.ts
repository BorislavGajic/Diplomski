import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {OperaterServiceService} from '../services/operater-service.service';
import {FormBuilder} from '@angular/forms';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-operater-kontrola',
  templateUrl: './operater-kontrola.component.html',
  styleUrls: ['./operater-kontrola.component.css']
})
export class OperaterKontrolaComponent implements OnInit {
  kontrole: any = [];
  kontrola: any = [];
  closeResult: string;
  constructor(private router: Router, private operaterService: OperaterServiceService , private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.ucitajKontrole();
  }

  // tslint:disable-next-line:typedef
  ucitajKontrole() {
    this.operaterService.getKontrole()
      .pipe(first())
      .subscribe(data => {
        this.kontrole = data;
        for ( const osigurac of this.kontrole){
          if (osigurac.reId === null) {
            osigurac.reId = [];
          }
        }
      });
  }

  // tslint:disable-next-line:typedef
  delete(kontrola) {
    this.kontrola = kontrola;
    this.operaterService.deleteTest(kontrola.kontrolaKey.qsId , kontrola.kontrolaKey.tosId )
      .pipe(first())
      .subscribe();
    this.ucitajKontrole();
  }

  // tslint:disable-next-line:typedef
  logout() {
    localStorage.removeItem('currentuser');
    this.router.navigate(['/']);

  }

  // tslint:disable-next-line:typedef
  MakeVote(){
    this.router.navigate(['/novaKontrola']);
  }

  // tslint:disable-next-line:typedef
  addReparacija(kontrola) {
    this.kontrola = kontrola;
    this.operaterService.settKontrola(kontrola);
    this.router.navigate(['/dodajReKont']);
  }

}
