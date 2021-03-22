import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-admin-materijal',
  templateUrl: './admin-materijal.component.html',
  styleUrls: ['./admin-materijal.component.css']
})
export class AdminMaterijalComponent implements OnInit {
  materijali: any = [];
  closeResult: string;
  MaterijalForm: FormGroup;
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.ucitajMaterijale();

    this.MaterijalForm = this.formBuilder.group({
      nazivMat: [''],
      opisMat: ['']
    });
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
  logout() {
    localStorage.removeItem('currentuser');
    this.router.navigate(['/']);

  }

  // tslint:disable-next-line:typedef
  delete(materijal) {
    this.adminService.deleteMaterijal(materijal.matId)
      .pipe(first())
      .subscribe();
    this.ucitajMaterijale();
  }

  // tslint:disable-next-line:typedef
  get formControls() { return this.MaterijalForm.controls; }

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
    this.adminService.registrujMaterijal(JSON.stringify(this.MaterijalForm.value))
      .pipe(first())
      .subscribe();
    this.ucitajMaterijale();
    this.modalService.dismissAll();
  }

}
