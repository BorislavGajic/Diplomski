import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {FormBuilder, FormGroup} from '@angular/forms';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';
import {OperaterServiceService} from '../services/operater-service.service';

@Component({
  selector: 'app-operater-osigurac',
  templateUrl: './operater-osigurac.component.html',
  styleUrls: ['./operater-osigurac.component.css']
})
export class OperaterOsiguracComponent implements OnInit {
  osiguraci: any = [];
  closeResult: string;
  OsiguracForm: FormGroup;

  osigurac: any = [];
  constructor(private router: Router, private operaterService: OperaterServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.ucitajOsigurace();

    this.OsiguracForm = this.formBuilder.group({
      maxNapon: [''],
      snaga: ['']
    });
  }

  // tslint:disable-next-line:typedef
  logout() {
    localStorage.removeItem('currentuser');
    this.router.navigate(['/']);

  }

  // tslint:disable-next-line:typedef
  ucitajOsigurace() {
    this.operaterService.getOsiguraci()
      .pipe(first())
      .subscribe(data => {
        this.osiguraci = data;
        for ( const osigurac of this.osiguraci){
          if (osigurac.moId === null) {
            osigurac.moId = [];
          }
          if (osigurac.riId === null) {
            osigurac.riId = [];
          }
          if (osigurac.paId === null) {
            osigurac.paId = [];
          }
          if (osigurac.mId === null) {
            osigurac.mId = [];
          }
          if (osigurac.pcId === null) {
            osigurac.pcId = [];
          }
          if (osigurac.tosId === null) {
            osigurac.tosId = [];
          }
          if (osigurac.tosMultipolId === null) {
            osigurac.tosMultipolId = [];
          }
          if (osigurac.kontrola === null) {
            osigurac.kontrola = [];
          }
          if (osigurac.test === null) {
            osigurac.test = [];
          }
        }
      });
  }

  // tslint:disable-next-line:typedef
  delete(osigurac) {
    this.operaterService.deleteOsigurac(osigurac.osId)
      .pipe(first())
      .subscribe();
    this.ucitajOsigurace();
  }

  // tslint:disable-next-line:typedef
  get formControls() { return this.OsiguracForm.controls; }

  // tslint:disable-next-line:typedef
  MakeVote(addVote){
    this.modalService.open(addVote, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  // tslint:disable-next-line:typedef
  create(){
    this.operaterService.registrujOsigurac(JSON.stringify(this.OsiguracForm.value))
      .pipe(first())
      .subscribe();
    this.ucitajOsigurace();
    this.modalService.dismissAll();
  }

  // tslint:disable-next-line:typedef
  izmeni(osigurac){
    this.osigurac = osigurac;
    this.operaterService.settOsigurac(this.osigurac);
    this.router.navigate(['/izmenaOsiguraca']);
  }

}
