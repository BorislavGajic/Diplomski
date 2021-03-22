import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {AuthService} from '../services/auth.service';

@Component({
  selector: 'app-login-agent',
  templateUrl: './login-agent.component.html',
  styleUrls: ['./login-agent.component.css']
})
export class LoginAgentComponent implements OnInit {
  loginForm: FormGroup;
  korisnik;

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private service: AuthService) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      korisnickoIme: ['', Validators.required],
      lozinka: ['', Validators.required]
    });
  }
  // tslint:disable-next-line:typedef
  onSubmit() {
    this.service.login(this.loginForm.value)
      .subscribe( data => {
        this.korisnik = data;
       // console.log(JSON.stringify(this.korisnik));
       // {"koId":1,"korisnickoIme":"999","lozinka":"999","aktivan":true,"radnikRId":
        // {"rId":18,"jmbg":"999","ime":"999","prezime":"999","plata":null,"bonus":null,"tekuciRacun":"999",
        // "radnikTip":"Admin","kancelarijaKaId":{"kaId":1,"kolStolicaK":50,"kolStolovaK":50,"kolOrmanaK":50,
        // "kolRacunara":50},"radnik_tip":"Admin"}}
        if (this.korisnik.aktivan && this.korisnik.radnikRId.radnikTip === 'Admin'){
          localStorage.setItem('currentuser', this.loginForm.value.korisnickoIme);
          this.router.navigate(['/admin']);
        }
        if (this.korisnik.aktivan && this.korisnik.radnikRId.radnikTip === 'Magacioner'){
          localStorage.setItem('currentuser', this.loginForm.value.korisnickoIme);
          this.router.navigate(['/magacioner']);
        }
        if (this.korisnik.aktivan && this.korisnik.radnikRId.radnikTip === 'Operater'){
          localStorage.setItem('currentuser', this.loginForm.value.korisnickoIme);
          this.router.navigate(['/operater']);
        }
      })
    ;
  }

}
