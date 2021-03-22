import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {AuthService} from '../services/auth.service';
import {first} from 'rxjs/operators';
import {KorisnikServiceService} from '../services/korisnik-service.service';
import {MagacionerServiceService} from '../services/magacioner-service.service';
import {OperaterServiceService} from '../services/operater-service.service';
import {AdminServiceService} from '../services/admin-service.service';

@Component({
  selector: 'app-registracion',
  templateUrl: './registracion.component.html',
  styleUrls: ['./registracion.component.css']
})
export class RegistracionComponent implements OnInit {
  korisnikForm: FormGroup;
  radnikRId;
  radnik: any = [];

  constructor(    private formBuilder: FormBuilder,
                  private router: Router,
                  private service: AuthService,
                  private korisnikService: KorisnikServiceService,
                  private magacionerService: MagacionerServiceService,
                  private operaterService: OperaterServiceService,
                  private adminService: AdminServiceService) { }

  ngOnInit(): void {
    this.korisnikForm = this.formBuilder.group({
      korisnickoIme: ['', Validators.required],
      lozinka: ['', Validators.required],
      ime: ['', Validators.required],
      prezime: ['', Validators.required],
      jmbg: ['', Validators.required],
      tekuciRacun: ['', Validators.required],
      uloga: ['Operater', Validators.required],
      radnikRId: [],
      kancelarija_Ka_id: [1],
      magacinMId: [1],
      pogonPId: [1]
    });


  }

  // tslint:disable-next-line:typedef
  get formControls() { return this.korisnikForm.controls; }

  // tslint:disable-next-line:typedef
  get myUloga() {
    console.log(this.korisnikForm.get('uloga'));
    return this.korisnikForm.get('uloga');
  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    if (this.myUloga.value === 'Admin'){
      this.adminService.registrujAdmina(JSON.stringify(this.korisnikForm.value))
        .pipe(first())
        .subscribe(mesData => {
          const rradnik = {
            radnikRId: mesData,
            korisnickoIme: this.korisnikForm.value.korisnickoIme,
            lozinka: this.korisnikForm.value.lozinka
          };
          this.korisnikService.registrujKorisnika(JSON.stringify(rradnik))
            .pipe(first())
            .subscribe();
          this.router.navigate(['/']);
        });
    }
    if (this.myUloga.value === 'Magacioner'){
        this.magacionerService.registrujMagacionera(this.korisnikForm.value)
        .pipe(first())
        .subscribe(mesData => {
          const rradnik = {
            radnikRId: mesData,
            korisnickoIme: this.korisnikForm.value.korisnickoIme,
            lozinka: this.korisnikForm.value.lozinka
          };
          this.korisnikService.registrujKorisnika(JSON.stringify(rradnik))
            .pipe(first())
            .subscribe();
          this.router.navigate(['/']);
        });
    }
    if (this.myUloga.value === 'Operater'){
      this.operaterService.registrujOperatera(this.korisnikForm.value)
        .pipe(first())
        .subscribe(mesData => {
          const rradnik = {
            radnikRId: mesData,
            korisnickoIme: this.korisnikForm.value.korisnickoIme,
            lozinka: this.korisnikForm.value.lozinka
          };
          this.korisnikService.registrujKorisnika(JSON.stringify(rradnik))
            .pipe(first())
            .subscribe();
          this.router.navigate(['/']);
        });
    }

  }
}