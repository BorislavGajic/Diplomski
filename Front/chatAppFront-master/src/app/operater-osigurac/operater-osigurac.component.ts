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
  MakeVote(){
    this.router.navigate(['/noviOsigurac']);
  }

}
