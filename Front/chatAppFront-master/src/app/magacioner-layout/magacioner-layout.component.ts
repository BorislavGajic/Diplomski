import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {FormBuilder} from '@angular/forms';
import {ChatService} from '../services/chat.service';
import {AuthService} from '../services/auth.service';
import {UsersService} from '../services/users.service';
import {AdminServiceService} from '../services/admin-service.service';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-magacioner-layout',
  templateUrl: './magacioner-layout.component.html',
  styleUrls: ['./magacioner-layout.component.css']
})
export class MagacionerLayoutComponent implements OnInit {
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
          if (this.admin.radnikTip !== 'Magacioner') {
            this.router.navigate(['/']);
          }
        }
      );
  }

}
