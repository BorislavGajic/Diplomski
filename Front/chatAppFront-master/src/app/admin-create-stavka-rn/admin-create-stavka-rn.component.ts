import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-admin-create-stavka-rn',
  templateUrl: './admin-create-stavka-rn.component.html',
  styleUrls: ['./admin-create-stavka-rn.component.css']
})
export class AdminCreateStavkaRnComponent implements OnInit {
  materijali: any = [];
  radniNalog: any = [];
  SRNForm: FormGroup;
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.ucitajMaterijale();

    this.SRNForm = this.formBuilder.group({
      rnId: [''],
      matId: [''],
      kolicinaRn: ['']
    });
  }

  // tslint:disable-next-line:typedef
  get formControls() { return this.SRNForm.controls; }

  // tslint:disable-next-line:typedef
  ucitajMaterijale() {
    this.adminService.getMaterijali()
      .pipe(first())
      .subscribe(data => {
        this.materijali = data;
      });
  }

  // tslint:disable-next-line:typedef
  create(){
    this.radniNalog = this.adminService.getRadniNalog();
    this.SRNForm.value.rnId = this.radniNalog.rnId;
    if (this.SRNForm.value.matId !== '' || this.SRNForm.value.kolicinaRn !== '') {
      this.adminService.registrujStavkuRN(JSON.stringify(this.SRNForm.value))
        .pipe(first())
        .subscribe();
      this.router.navigate(['/admin/radniNalogAdmin']);
    }
    else{
      this.modalService.open('Polja nisu popunjena');
    }
  }
  // tslint:disable-next-line:typedef
  MakeVote() {
    this.router.navigate(['/admin/radniNalogAdmin']);
  }
}
