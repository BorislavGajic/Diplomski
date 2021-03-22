import { Component, OnInit } from '@angular/core';

declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}

export const ROUTES: RouteInfo[] = [
  { path: '/admin/profilAdmin', title: 'Profil',  icon: '', class: '' },
  { path: '/admin/kancelarijeAdmin', title: 'Kancelarije',  icon: '', class: '' },
  { path: '/admin/magaciniAdmin', title: 'Magacini',  icon: '', class: '' },
  { path: '/admin/pogoniAdmin', title: 'Pogoni',  icon: '', class: '' },
  { path: '/admin/materijalAdmin', title: 'Materijali',  icon: '', class: '' },
  { path: '/admin/radniNalogAdmin', title: 'Radni nalozi',  icon: '', class: '' },
  { path: '/admin/sastavnicaAdmin', title: 'Sastavnice',  icon: '', class: '' },
  { path: '/admin/sektorPogonaAdmin', title: 'Sektor pogona',  icon: '', class: '' },
  { path: '/admin/tipOsiguracaAdmin', title: 'Tip osiguraca',  icon: '', class: '' }

];

@Component({
  selector: 'app-admin-sidebar',
  templateUrl: './admin-sidebar.component.html',
  styleUrls: ['./admin-sidebar.component.css']
})
export class AdminSidebarComponent implements OnInit {

  menuItems: any[];
  constructor() { }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }

}
