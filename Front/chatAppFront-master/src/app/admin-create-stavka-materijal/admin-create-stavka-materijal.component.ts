import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {first} from 'rxjs/operators';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-admin-create-stavka-materijal',
  templateUrl: './admin-create-stavka-materijal.component.html',
  styleUrls: ['./admin-create-stavka-materijal.component.css']
})
export class AdminCreateStavkaMaterijalComponent implements OnInit {
  materijali: any = [];
  sastavnica: any = [];
  StavkaMaterijalForm: FormGroup;
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.StavkaMaterijalForm = this.formBuilder.group({
      sId: [''],
      matId: ['']
    });
    this.ucitajMaterijale();
  }

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
    this.sastavnica = this.adminService.getSastavnica();
    this.StavkaMaterijalForm.value.sId = this.sastavnica.sId;
    if (this.StavkaMaterijalForm.value.matId !== '') {
      this.adminService.dodajMatUStavku(JSON.stringify(this.StavkaMaterijalForm.value), this.sastavnica.sId)
        .pipe(first())
        .subscribe();
      this.router.navigate(['/admin/sastavnicaAdmin']);
    }
    else{
      this.modalService.open('Polja nisu popunjena');
    }

  }
  // tslint:disable-next-line:typedef
  MakeVote() {
    this.router.navigate(['/admin/sastavnicaAdmin']);
  }

}
