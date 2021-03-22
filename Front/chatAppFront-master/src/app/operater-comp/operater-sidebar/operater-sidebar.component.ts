import { Component, OnInit } from '@angular/core';

declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}

export const ROUTES: RouteInfo[] = [
  { path: '/operater/operaterProfil', title: 'Profil',  icon: '', class: '' },
  { path: '/operater/operaterOsigurac', title: 'Osiguraci',  icon: '', class: '' }
];

@Component({
  selector: 'app-operater-sidebar',
  templateUrl: './operater-sidebar.component.html',
  styleUrls: ['./operater-sidebar.component.css']
})
export class OperaterSidebarComponent implements OnInit {

  menuItems: any[];
  constructor() { }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }

}
