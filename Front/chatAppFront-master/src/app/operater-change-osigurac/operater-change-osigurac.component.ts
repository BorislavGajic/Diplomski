import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {AdminServiceService} from '../services/admin-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {OperaterServiceService} from '../services/operater-service.service';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-operater-change-osigurac',
  templateUrl: './operater-change-osigurac.component.html',
  styleUrls: ['./operater-change-osigurac.component.css']
})
export class OperaterChangeOsiguracComponent implements OnInit {
  osigurac: any = [];
  OCForm: FormGroup;

  montaze: any = [];
  riveti: any = [];
  pakeraji: any = [];
  magacini: any = [];
  printCentri: any = [];
  tipoviOsiguraca: any = [];

  constructor(private router: Router, private operaterService: OperaterServiceService, private formBuilder: FormBuilder,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.OCForm = this.formBuilder.group({
      osId: [''],
      moId: [''],
      riId: [''],
      paId: [''],
      mId: [''],
      pcId: [''],
      tosId: ['']
    });
    this.osigurac = this.operaterService.gettOsigurac();
    this.ucitajMontaze();
    this.ucitajRivete();
    this.ucitajPakeraje();
    this.ucitajMagacine();
    this.ucitajPrintCentre();
    this.ucitajTipoveOsiguraca();
  }

  // tslint:disable-next-line:typedef
  ucitajMontaze() {
    this.operaterService.getMontaze()
      .pipe(first())
      .subscribe(data => {
        this.montaze = data;
      });
  }

  // tslint:disable-next-line:typedef
  ucitajRivete() {
    this.operaterService.getRiveti()
      .pipe(first())
      .subscribe(data => {
        this.riveti = data;
      });
  }

  // tslint:disable-next-line:typedef
  ucitajPrintCentre() {
    this.operaterService.getPrintCentri()
      .pipe(first())
      .subscribe(data => {
        this.printCentri = data;
      });
  }

  // tslint:disable-next-line:typedef
  ucitajPakeraje() {
    this.operaterService.getPakeraji()
      .pipe(first())
      .subscribe(data => {
        this.pakeraji = data;
      });
  }

  // tslint:disable-next-line:typedef
  ucitajTipoveOsiguraca() {
    this.operaterService.getTipoviOs()
      .pipe(first())
      .subscribe(data => {
        this.tipoviOsiguraca = data;
      });
  }

  // tslint:disable-next-line:typedef
  ucitajMagacine() {
    this.operaterService.getMagacini()
      .pipe(first())
      .subscribe(data => {
        this.magacini = data;
      });
  }

  // tslint:disable-next-line:typedef
  create(){
    this.router.navigate(['/operater/operaterOsigurac']);
  }
  // tslint:disable-next-line:typedef
  MakeVote() {
    this.router.navigate(['/operater/operaterOsigurac']);
  }

  // tslint:disable-next-line:typedef
  MakeVote1(moId) {
    this.OCForm.value.osId = this.osigurac.osId;
    this.OCForm.value.moId = moId;
    this.operaterService.putMontaza(JSON.stringify(this.OCForm.value))
        .pipe(first())
        .subscribe();
  }

  // tslint:disable-next-line:typedef
  MakeVote2(riId) {
    this.OCForm.value.osId = this.osigurac.osId;
    this.OCForm.value.riId = riId;
    this.operaterService.putRivet(JSON.stringify(this.OCForm.value))
      .pipe(first())
      .subscribe();
  }

  // tslint:disable-next-line:typedef
  MakeVote3(pcId) {
    this.OCForm.value.osId = this.osigurac.osId;
    this.OCForm.value.pcId = pcId;
    this.operaterService.putPrintCentar(JSON.stringify(this.OCForm.value))
      .pipe(first())
      .subscribe();
  }

  // tslint:disable-next-line:typedef
  MakeVote4(paId) {
    this.OCForm.value.osId = this.osigurac.osId;
    this.OCForm.value.paId = paId;
    this.operaterService.putPakeraj(JSON.stringify(this.OCForm.value))
      .pipe(first())
      .subscribe();
  }

  // tslint:disable-next-line:typedef
  MakeVote5(mId) {
    this.OCForm.value.osId = this.osigurac.osId;
    this.OCForm.value.mId = mId;
    this.operaterService.putMagacin(JSON.stringify(this.OCForm.value))
      .pipe(first())
      .subscribe();
  }

  // tslint:disable-next-line:typedef
  MakeVote6(tosId) {
    this.OCForm.value.osId = this.osigurac.osId;
    this.OCForm.value.tosId = tosId;
    this.operaterService.putTipOsiguraca(JSON.stringify(this.OCForm.value))
        .pipe(first())
        .subscribe();

  }

}
