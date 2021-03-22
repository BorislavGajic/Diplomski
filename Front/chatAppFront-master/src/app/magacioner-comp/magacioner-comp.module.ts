import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MagacionerNavbarComponent } from './magacioner-navbar/magacioner-navbar.component';
import { MagacionerSidebarComponent } from './magacioner-sidebar/magacioner-sidebar.component';
import {NgbCollapseModule, NgbDropdownModule} from '@ng-bootstrap/ng-bootstrap';
import {RouterModule} from '@angular/router';



@NgModule({
  declarations: [MagacionerNavbarComponent, MagacionerSidebarComponent],
  exports: [MagacionerNavbarComponent, MagacionerSidebarComponent],
  imports: [
    CommonModule,
    NgbCollapseModule,
    RouterModule,
    NgbDropdownModule
  ]
})
export class MagacionerCompModule { }
