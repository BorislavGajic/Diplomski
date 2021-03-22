import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {FormBuilder, FormGroup} from '@angular/forms';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-admin-create-sektor-pogona',
  templateUrl: './admin-create-sektor-pogona.component.html',
  styleUrls: ['./admin-create-sektor-pogona.component.css']
})
export class AdminCreateSektorPogonaComponent implements OnInit {
  SPForm: FormGroup;
  pogoni: any = [];
  tipSP: any = ['Montaza' , 'Rivet', 'Test_linija' , 'Reparacija' , 'Multipol' , 'Print_centar' , 'Pakeraj' , 'QS_kontrola'];
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.SPForm = this.formBuilder.group({
      maxKolZap: [''],
      kolMasinaSp: [''],
      povrsina: [''],
      pogonPId: [''],
      nazivSp: [''],
      tipSp: ['']
    });
    this.ucitajPogone();
  }

  // tslint:disable-next-line:typedef
  ucitajPogone() {
    this.adminService.getPogone()
      .pipe(first())
      .subscribe(data => {
        this.pogoni = data;
      });
  }

  // tslint:disable-next-line:typedef
  create(){
    if (this.SPForm.value.maxKolZap !== '' && this.SPForm.value.kolMasinaSp !== ''
      && this.SPForm.value.povrsina !== ''  && this.SPForm.value.pogonPId !== ''
      && this.SPForm.value.nazivSp !== '' && this.SPForm.value.tipSp !== '') {
      if (this.SPForm.value.tipSp === 'Montaza'){
        this.adminService.registrujMontazu(JSON.stringify(this.SPForm.value))
          .pipe(first())
          .subscribe();
        this.router.navigate(['/admin/sektorPogonaAdmin']);
      }
      if (this.SPForm.value.tipSp === 'Rivet'){
        this.adminService.registrujRivet(JSON.stringify(this.SPForm.value))
          .pipe(first())
          .subscribe();
        this.router.navigate(['/admin/sektorPogonaAdmin']);
      }
      if (this.SPForm.value.tipSp === 'Test_linija'){
        this.adminService.registrujTestLiniju(JSON.stringify(this.SPForm.value))
          .pipe(first())
          .subscribe();
        this.router.navigate(['/admin/sektorPogonaAdmin']);
      }
      if (this.SPForm.value.tipSp === 'Reparacija'){
        this.adminService.registrujReparaciju(JSON.stringify(this.SPForm.value))
          .pipe(first())
          .subscribe();
        this.router.navigate(['/admin/sektorPogonaAdmin']);
      }
      if (this.SPForm.value.tipSp === 'Multipol'){
        this.adminService.registrujMultipol(JSON.stringify(this.SPForm.value))
          .pipe(first())
          .subscribe();
        this.router.navigate(['/admin/sektorPogonaAdmin']);
      }
      if (this.SPForm.value.tipSp === 'Print_centar'){
        this.adminService.registrujPrintCentar(JSON.stringify(this.SPForm.value))
          .pipe(first())
          .subscribe();
        this.router.navigate(['/admin/sektorPogonaAdmin']);
      }
      if (this.SPForm.value.tipSp === 'Pakeraj'){
        this.adminService.registrujPakeraj(JSON.stringify(this.SPForm.value))
          .pipe(first())
          .subscribe();
        this.router.navigate(['/admin/sektorPogonaAdmin']);
      }
      if (this.SPForm.value.tipSp === 'QS_kontrola'){
        this.adminService.registrujQSKontrolu(JSON.stringify(this.SPForm.value))
          .pipe(first())
          .subscribe();
        this.router.navigate(['/admin/sektorPogonaAdmin']);
      }
    }
    else{
      this.modalService.open('Polja nisu popunjena');
    }

  }
  // tslint:disable-next-line:typedef
  MakeVote() {
    this.router.navigate(['/admin/sektorPogonaAdmin']);
  }

}
