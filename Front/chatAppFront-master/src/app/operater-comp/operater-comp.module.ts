import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OperaterNavbarComponent } from './operater-navbar/operater-navbar.component';
import { OperaterSidebarComponent } from './operater-sidebar/operater-sidebar.component';
import {NgbCollapseModule, NgbDropdownModule} from '@ng-bootstrap/ng-bootstrap';
import {RouterModule} from '@angular/router';



@NgModule({
  declarations: [OperaterNavbarComponent, OperaterSidebarComponent],
  exports: [OperaterNavbarComponent, OperaterSidebarComponent],
  imports: [
    CommonModule,
    NgbCollapseModule,
    RouterModule,
    NgbDropdownModule
  ]
})
export class OperaterCompModule { }
