import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OperaterLayoutComponent } from './operater-layout.component';
import {OperaterCompModule} from '../operater-comp/operater-comp.module';
import {RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FlatpickrModule} from 'angularx-flatpickr';
import {OperaterLayoutRutes} from './operater-layout.routing';
import {OperaterProfilComponent} from '../operater-profil/operater-profil.component';
import {OperaterOsiguracComponent} from '../operater-osigurac/operater-osigurac.component';



@NgModule({
  declarations: [OperaterLayoutComponent,
    OperaterProfilComponent,
    OperaterOsiguracComponent],
  exports: [OperaterLayoutComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(OperaterLayoutRutes),
    FormsModule,
    NgbModule,
    ReactiveFormsModule,
    FlatpickrModule.forRoot(),
    OperaterCompModule
  ]
})
export class OperaterLayoutModule { }
