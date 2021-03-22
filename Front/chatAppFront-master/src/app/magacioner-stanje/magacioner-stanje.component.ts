import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {MagacionerServiceService} from '../services/magacioner-service.service';
import {first} from 'rxjs/operators';
import {FormBuilder, FormGroup} from '@angular/forms';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-magacioner-stanje',
  templateUrl: './magacioner-stanje.component.html',
  styleUrls: ['./magacioner-stanje.component.css']
})
export class MagacionerStanjeComponent implements OnInit {
  stanja: any = [];
  constructor(private router: Router, private modalService: NgbModal,
              private magacionerService: MagacionerServiceService,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.ucitajStanja();
  }

  // tslint:disable-next-line:typedef
  ucitajStanja() {
    this.magacionerService.getStanja()
      .pipe(first())
      .subscribe(data => {
        this.stanja = data;
      });
  }

  // tslint:disable-next-line:typedef
  logout() {
    localStorage.removeItem('currentuser');
    this.router.navigate(['/']);

  }

  // tslint:disable-next-line:typedef
  delete(stanje) {
    this.magacionerService.deleteStanje(stanje.stanjeKey.mId , stanje.stanjeKey.matId)
      .pipe(first())
      .subscribe();
    this.ucitajStanja();
  }

  // tslint:disable-next-line:typedef
  MakeVote(){
    this.router.navigate(['/novoStanje']);
  }

}
