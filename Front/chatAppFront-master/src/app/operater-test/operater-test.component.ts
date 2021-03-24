import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {OperaterServiceService} from '../services/operater-service.service';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-operater-test',
  templateUrl: './operater-test.component.html',
  styleUrls: ['./operater-test.component.css']
})
export class OperaterTestComponent implements OnInit {
  testovi: any = [];
  test: any = [];
  closeResult: string;
  constructor(private router: Router, private operaterService: OperaterServiceService , private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.ucitajTestove();
  }

  // tslint:disable-next-line:typedef
  ucitajTestove() {
    this.operaterService.getTestovi()
      .pipe(first())
      .subscribe(data => {
        this.testovi = data;
        for ( const osigurac of this.testovi){
          if (osigurac.reId === null) {
            osigurac.reId = [];
          }
        }
      });
  }

  // tslint:disable-next-line:typedef
  delete(test) {
    this.test = test;
    this.operaterService.deleteTest(test.testKey.tlId , test.testKey.tosId )
      .pipe(first())
      .subscribe();
    this.ucitajTestove();
  }

  // tslint:disable-next-line:typedef
  logout() {
    localStorage.removeItem('currentuser');
    this.router.navigate(['/']);

  }

  // tslint:disable-next-line:typedef
  MakeVote(){
    this.router.navigate(['/noviTest']);
  }

}
