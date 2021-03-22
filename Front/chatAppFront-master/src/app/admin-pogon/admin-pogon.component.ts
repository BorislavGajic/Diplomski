import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-admin-pogon',
  templateUrl: './admin-pogon.component.html',
  styleUrls: ['./admin-pogon.component.css']
})
export class AdminPogonComponent implements OnInit {
  pogoni: any = [];
  closeResult: string;
  PogoniForm: FormGroup;
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.ucitajPogone();

    this.PogoniForm = this.formBuilder.group({
      kolOrmanaP: [''],
      kolStolicaP: [''],
      kolStolovaP: [''],
      kolMasinaP: ['']
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
  logout() {
    localStorage.removeItem('currentuser');
    this.router.navigate(['/']);

  }

  // tslint:disable-next-line:typedef
  delete(pogon) {
    this.adminService.deletePogon(pogon.pid)
      .pipe(first())
      .subscribe();
    this.ucitajPogone();
  }

  // tslint:disable-next-line:typedef
  get formControls() { return this.PogoniForm.controls; }

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
    this.adminService.registrujPogon(JSON.stringify(this.PogoniForm.value))
      .pipe(first())
      .subscribe();
    this.ucitajPogone();
    this.modalService.dismissAll();
  }

}
