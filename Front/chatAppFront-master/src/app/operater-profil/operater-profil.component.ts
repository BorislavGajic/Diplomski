import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {ChatService} from '../services/chat.service';
import {AuthService} from '../services/auth.service';
import {Router} from '@angular/router';
import {UsersService} from '../services/users.service';
import {AdminServiceService} from '../services/admin-service.service';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-operater-profil',
  templateUrl: './operater-profil.component.html',
  styleUrls: ['./operater-profil.component.css']
})
export class OperaterProfilComponent implements OnInit {

  admin: any = [];
  korisnik: any = [];
  constructor(private formBuilder: FormBuilder, private chatService: ChatService, private authService: AuthService,
              private router: Router, private service: UsersService, private adminService: AdminServiceService) { }

  ngOnInit(): void {
    this.ucitajAdmina();
  }

  // tslint:disable-next-line:typedef
  ucitajAdmina() {
    this.authService.getUser(localStorage.getItem('currentuser').toString())
      .pipe(first())
      .subscribe((data: {}) => {
          this.korisnik = data;
          this.admin = this.korisnik.radnikRId;
        }
      );
  }

  // tslint:disable-next-line:typedef
  logout() {
    localStorage.removeItem('currentuser');
    this.router.navigate(['/']);

  }

}
