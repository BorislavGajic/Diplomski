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
import {OperaterRadniNalogComponent} from '../operater-radni-nalog/operater-radni-nalog.component';
import {OperaterTestComponent} from '../operater-test/operater-test.component';
import {OperaterKontrolaComponent} from '../operater-kontrola/operater-kontrola.component';
import {OperaterTomComponent} from '../operater-tom/operater-tom.component';



@NgModule({
  declarations: [OperaterLayoutComponent,
    OperaterProfilComponent,
    OperaterOsiguracComponent,
    OperaterRadniNalogComponent,
    OperaterTestComponent,
    OperaterKontrolaComponent,
    OperaterTomComponent],
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
