import { Component, OnInit } from '@angular/core';
import {first} from 'rxjs/operators';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-admin-create-radni-nalog',
  templateUrl: './admin-create-radni-nalog.component.html',
  styleUrls: ['./admin-create-radni-nalog.component.css']
})
export class AdminCreateRadniNalogComponent implements OnInit {
  pogoni: any = [];
  kancelarije: any = [];
  RadniNalogForm: FormGroup;
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.ucitajPogone();
    this.ucitajKancelarije();

    this.RadniNalogForm = this.formBuilder.group({
      pogonPId: [''],
      kancelarijaKaId: ['']
    });
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
  ucitajKancelarije() {
    this.adminService.getKancelarijas()
      .pipe(first())
      .subscribe(data => {
        this.kancelarije = data;
      });
  }

  // tslint:disable-next-line:typedef
  create(){
    if (this.RadniNalogForm.value.pogonPId !== '' || this.RadniNalogForm.value.kancelarijaKaId !== '') {
    this.adminService.registrujRadniNalog(JSON.stringify(this.RadniNalogForm.value))
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
