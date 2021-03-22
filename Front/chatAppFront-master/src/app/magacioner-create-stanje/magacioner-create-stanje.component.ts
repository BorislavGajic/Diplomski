import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {MagacionerServiceService} from '../services/magacioner-service.service';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-magacioner-create-stanje',
  templateUrl: './magacioner-create-stanje.component.html',
  styleUrls: ['./magacioner-create-stanje.component.css']
})
export class MagacionerCreateStanjeComponent implements OnInit {
  materijali: any = [];
  magacini: any = [];
  StanjeForm: FormGroup;
  constructor(private router: Router, private modalService: NgbModal,
              private magacionerService: MagacionerServiceService,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.ucitajMagacine();
    this.ucitajMaterijale();

    this.StanjeForm = this.formBuilder.group({
      mId: [''],
      matId: ['']
    });
  }

  // tslint:disable-next-line:typedef
  ucitajMagacine() {
    this.magacionerService.getMagacine()
      .pipe(first())
      .subscribe(data => {
        this.magacini = data;
        console.log(this.magacini);
      });
  }

  // tslint:disable-next-line:typedef
  ucitajMaterijale() {
    this.magacionerService.getMaterijali()
      .pipe(first())
      .subscribe(data => {
        this.materijali = data;
      });
  }

  // tslint:disable-next-line:typedef
  create(){
    if (this.StanjeForm.value.mId !== '' || this.StanjeForm.value.matId !== '') {
      this.magacionerService.registrujStanje(JSON.stringify(this.StanjeForm.value))
        .pipe(first())
        .subscribe();
      this.router.navigate(['/magacioner/magacionerStanje']);
    }
    else{
      this.modalService.open('Polja nisu popunjena');
    }

  }

  // tslint:disable-next-line:typedef
  MakeVote(){
    this.router.navigate(['/magacioner/magacionerStanje']);
  }

}
