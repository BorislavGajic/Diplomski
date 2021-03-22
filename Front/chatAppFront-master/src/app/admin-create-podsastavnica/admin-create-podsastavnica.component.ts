import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-admin-create-podsastavnica',
  templateUrl: './admin-create-podsastavnica.component.html',
  styleUrls: ['./admin-create-podsastavnica.component.css']
})
export class AdminCreatePodsastavnicaComponent implements OnInit {
  sastavniceStare: any = [];
  PodsastavnicaForm: FormGroup;
  sastavnica: any = [];
  forSastavnica: any = [];
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.PodsastavnicaForm = this.formBuilder.group({
      sId: ['']
    });
    this.sastavnica = this.adminService.getSastavnica();
    this.ucitajSastavnice();
  }

  // tslint:disable-next-line:typedef
  ucitajSastavnice() {
    this.adminService.getSastavniceSemNje(this.sastavnica.sId)
      .pipe(first())
      .subscribe(data => {
        this.sastavniceStare = data;
      });
  }

  // tslint:disable-next-line:typedef
  create(){
    if (this.PodsastavnicaForm.value.sId !== '') {
      this.adminService.dodajPodsastavnicu(JSON.stringify(this.PodsastavnicaForm.value), this.sastavnica.sId)
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
