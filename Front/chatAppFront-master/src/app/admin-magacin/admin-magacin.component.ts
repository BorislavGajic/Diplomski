import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-admin-magacin',
  templateUrl: './admin-magacin.component.html',
  styleUrls: ['./admin-magacin.component.css']
})
export class AdminMagacinComponent implements OnInit {
  magacini: any = [];
  closeResult: string;
  MagaciniForm: FormGroup;
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.ucitajMagacine();

    this.MagaciniForm = this.formBuilder.group({
      maxKolMaterijala: [''],
      kolViljuskara: [''],
      kolPaleta: [''],
      kolOrmanaM: ['']
    });
  }

  // tslint:disable-next-line:typedef
  ucitajMagacine() {
    this.adminService.getMagacine()
      .pipe(first())
      .subscribe(data => {
        this.magacini = data;
      });
  }

  // tslint:disable-next-line:typedef
  logout() {
    localStorage.removeItem('currentuser');
    this.router.navigate(['/']);

  }

  // tslint:disable-next-line:typedef
  delete(kancelarija) {
    this.adminService.deleteMagacin(kancelarija.mid)
      .pipe(first())
      .subscribe();
    this.ucitajMagacine();
  }

  // tslint:disable-next-line:typedef
  get formControls() { return this.MagaciniForm.controls; }

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
    this.adminService.registrujMagacin(JSON.stringify(this.MagaciniForm.value))
      .pipe(first())
      .subscribe();
    this.ucitajMagacine();
    this.modalService.dismissAll();
  }

}
