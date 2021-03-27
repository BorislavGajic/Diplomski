import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule} from '@angular/router';
import {AppRoutingModule} from './app.routing';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {FlatpickrModule} from 'angularx-flatpickr';
import {MatButtonModule, MatDatepickerModule, MatFormFieldModule, MatNativeDateModule, MatSelectModule} from '@angular/material';
import {AgentLayoutModule} from './agent-layout/agent-layout.module';
import { LoginAgentComponent } from './login-agent/login-agent.component';
import { RegistracionComponent } from './registracion/registracion.component';
import {AdminLayoutModule} from './admin-layout/admin-layout.module';
import {MagacionerLayoutModule} from './magacioner-layout/magacioner-layout.module';
import {OperaterLayoutModule} from './operater-layout/operater-layout.module';
import { AdminCreateRadniNalogComponent } from './admin-create-radni-nalog/admin-create-radni-nalog.component';
import { AdminCreateStavkaRnComponent } from './admin-create-stavka-rn/admin-create-stavka-rn.component';
import { MagacionerCreateStanjeComponent } from './magacioner-create-stanje/magacioner-create-stanje.component';
import { AdminCreateSastavnicaComponent } from './admin-create-sastavnica/admin-create-sastavnica.component';
import { AdminCreateStavkaSastavnicaComponent } from './admin-create-stavka-sastavnica/admin-create-stavka-sastavnica.component';
import { AdminCreateTipSastavnicaComponent } from './admin-create-tip-sastavnica/admin-create-tip-sastavnica.component';
import { AdminCreatePodsastavnicaComponent } from './admin-create-podsastavnica/admin-create-podsastavnica.component';
import { AdminCreateSsTrebovanjeComponent } from './admin-create-ss-trebovanje/admin-create-ss-trebovanje.component';
import { AdminCreateStavkaMaterijalComponent } from './admin-create-stavka-materijal/admin-create-stavka-materijal.component';
import { AdminCreateStavkeVezaComponent } from './admin-create-stavke-veza/admin-create-stavke-veza.component';
import { AdminCreateSektorPogonaComponent } from './admin-create-sektor-pogona/admin-create-sektor-pogona.component';
import { OperaterChangeOsiguracComponent } from './operater-change-osigurac/operater-change-osigurac.component';
import { OperaterCreateTestComponent } from './operater-create-test/operater-create-test.component';
import { OperaterCreateKontrolaComponent } from './operater-create-kontrola/operater-create-kontrola.component';
import { OperaterCreateRekonComponent } from './operater-create-rekon/operater-create-rekon.component';
import { OperaterCreateRetestComponent } from './operater-create-retest/operater-create-retest.component';
import { AdminTipTestComponent } from './admin-tip-test/admin-tip-test.component';
import { AdminTipKontrolaComponent } from './admin-tip-kontrola/admin-tip-kontrola.component';
import { AdminCreateTipKontrolaComponent } from './admin-create-tip-kontrola/admin-create-tip-kontrola.component';
import { AdminCreateTipTestComponent } from './admin-create-tip-test/admin-create-tip-test.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginAgentComponent,
    RegistracionComponent,
    AdminCreateRadniNalogComponent,
    AdminCreateStavkaRnComponent,
    MagacionerCreateStanjeComponent,
    AdminCreateSastavnicaComponent,
    AdminCreateStavkaSastavnicaComponent,
    AdminCreateTipSastavnicaComponent,
    AdminCreatePodsastavnicaComponent,
    AdminCreateSsTrebovanjeComponent,
    AdminCreateStavkaMaterijalComponent,
    AdminCreateStavkeVezaComponent,
    AdminCreateSektorPogonaComponent,
    OperaterChangeOsiguracComponent,
    OperaterCreateTestComponent,
    OperaterCreateKontrolaComponent,
    OperaterCreateRekonComponent,
    OperaterCreateRetestComponent,
    AdminCreateTipKontrolaComponent,
    AdminCreateTipTestComponent
  ],
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    AppRoutingModule,
    NgbModule,
    ReactiveFormsModule,
    AgentLayoutModule,
    AdminLayoutModule,
    MagacionerLayoutModule,
    OperaterLayoutModule,
    FontAwesomeModule,
    FlatpickrModule.forRoot(),
    MatFormFieldModule,
    MatSelectModule,
    MatDatepickerModule,
    MatButtonModule,
    MatFormFieldModule,
    MatNativeDateModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
