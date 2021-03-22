import { Component, OnInit } from '@angular/core';
declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}

export const ROUTES: RouteInfo[] = [
  { path: '/magacioner/magacionerProfil', title: 'Profil',  icon: '', class: '' },
  { path: '/magacioner/magacionerStanje', title: 'Stanje',  icon: '', class: '' }
];

@Component({
  selector: 'app-magacioner-sidebar',
  templateUrl: './magacioner-sidebar.component.html',
  styleUrls: ['./magacioner-sidebar.component.css']
})
export class MagacionerSidebarComponent implements OnInit {

  menuItems: any[];
  constructor() { }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }

}
