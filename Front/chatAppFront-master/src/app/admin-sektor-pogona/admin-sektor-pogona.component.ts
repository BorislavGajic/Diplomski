import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {FormBuilder, FormGroup} from '@angular/forms';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-admin-sektor-pogona',
  templateUrl: './admin-sektor-pogona.component.html',
  styleUrls: ['./admin-sektor-pogona.component.css']
})
export class AdminSektorPogonaComponent implements OnInit {
  sektoriPogona: any = [];
  closeResult: string;

  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.ucitajSPs();

  }

  // tslint:disable-next-line:typedef
  ucitajSPs() {
    this.adminService.getSPs()
      .pipe(first())
      .subscribe(data => {
        this.sektoriPogona = data;
      });
  }

  // tslint:disable-next-line:typedef
  logout() {
    localStorage.removeItem('currentuser');
    this.router.navigate(['/']);

  }

  // tslint:disable-next-line:typedef
  delete(sp) {
    this.adminService.deleteSp(sp.spId)
      .pipe(first())
      .subscribe();
    this.ucitajSPs();
  }

  // tslint:disable-next-line:typedef
  MakeVote(){
    this.router.navigate(['/noviSektorPogona']);
  }

}
