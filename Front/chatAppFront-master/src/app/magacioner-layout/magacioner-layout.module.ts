import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MagacionerLayoutComponent} from './magacioner-layout.component';
import {RouterModule} from '@angular/router';
import {AdminLayoutRutes} from '../admin-layout/admin-layout.routing';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FlatpickrModule} from 'angularx-flatpickr';
import {MagacionerCompModule} from '../magacioner-comp/magacioner-comp.module';
import {MagacionerLayoutRutes} from './magacioner-layout.routing';
import {MagacionerProfilComponent} from '../magacioner-profil/magacioner-profil.component';
import {MagacionerStanjeComponent} from '../magacioner-stanje/magacioner-stanje.component';
import {MatFormFieldModule, MatSelectModule} from '@angular/material';



@NgModule({
  declarations: [MagacionerLayoutComponent,
    MagacionerProfilComponent,
    MagacionerStanjeComponent],
  exports: [MagacionerLayoutComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(MagacionerLayoutRutes),
    FormsModule,
    NgbModule,
    ReactiveFormsModule,
    FlatpickrModule.forRoot(),
    MagacionerCompModule,
    MatFormFieldModule,
    MatSelectModule
  ]
})
export class MagacionerLayoutModule { }
