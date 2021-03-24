import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {FormBuilder} from '@angular/forms';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-admin-tip-multipola',
  templateUrl: './admin-tip-multipola.component.html',
  styleUrls: ['./admin-tip-multipola.component.css']
})
export class AdminTipMultipolaComponent implements OnInit {
  tipoviMultipola: any = [];
  constructor(private router: Router, private adminService: AdminServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.ucitajTIpoveMultipola();
  }

  // tslint:disable-next-line:typedef
  logout() {
    localStorage.removeItem('currentuser');
    this.router.navigate(['/']);

  }

  // tslint:disable-next-line:typedef
  ucitajTIpoveMultipola() {
    this.adminService.getTipoviMultipola()
      .pipe(first())
      .subscribe(data => {
        this.tipoviMultipola = data;
      });
  }

  // tslint:disable-next-line:typedef
  delete(tom) {
    this.adminService.deleteTOM(tom.muId.spId, tom.tosId.tosId )
      .pipe(first())
      .subscribe();
    this.ucitajTIpoveMultipola();
  }

  // tslint:disable-next-line:typedef
  MakeVote(){
    this.router.navigate(['/noviTipMultipola']);
  }

}
