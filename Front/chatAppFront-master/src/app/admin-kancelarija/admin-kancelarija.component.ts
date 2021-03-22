import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {first} from 'rxjs/operators';
import {AdminServiceService} from '../services/admin-service.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-admin-kancelarija',
  templateUrl: './admin-kancelarija.component.html',
  styleUrls: ['./admin-kancelarija.component.css']
})
export class AdminKancelarijaComponent implements OnInit {
  kancelarije: any = [];
  closeResult: string;
  KancelarijaForm: FormGroup;

  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.ucitajKancelarije();

    this.KancelarijaForm = this.formBuilder.group({
      kol_ormana_k: [''],
      kol_racunara: [''],
      kol_stolica_k: [''],
      kol_stolova_k: ['']
    });
  }

  // tslint:disable-next-line:typedef
  ucitajKancelarije() {
    this.adminService.getKancelarijas()
      .pipe(first())
      .subscribe(data => {
        this.kancelarije = data;
      });
  }

  // tslint:disable-next-line:typedef
  logout() {
    localStorage.removeItem('currentuser');
    this.router.navigate(['/']);

  }

  // tslint:disable-next-line:typedef
  delete(kancelarija) {
    this.adminService.deleteKancelarija(kancelarija.kaId)
      .pipe(first())
      .subscribe();
    this.ucitajKancelarije();
  }

  // tslint:disable-next-line:typedef
  get formControls() { return this.KancelarijaForm.controls; }

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
    this.adminService.registrujKancelariju(JSON.stringify(this.KancelarijaForm.value))
      .pipe(first())
      .subscribe();
    this.ucitajKancelarije();
    this.modalService.dismissAll();
  }

}
