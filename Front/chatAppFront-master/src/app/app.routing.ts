import {Routes, RouterModule} from '@angular/router';
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BrowserModule} from '@angular/platform-browser';
import {AgentLayoutComponent} from './agent-layout/agent-layout.component';
import {LoginAgentComponent} from './login-agent/login-agent.component';
import {RegistracionComponent} from './registracion/registracion.component';
import {AdminLayoutComponent} from './admin-layout/admin-layout.component';
import {MagacionerLayoutComponent} from './magacioner-layout/magacioner-layout.component';
import {OperaterLayoutComponent} from './operater-layout/operater-layout.component';
import {AdminCreateRadniNalogComponent} from './admin-create-radni-nalog/admin-create-radni-nalog.component';
import {AdminCreateStavkaRnComponent} from './admin-create-stavka-rn/admin-create-stavka-rn.component';
import {MagacionerCreateStanjeComponent} from './magacioner-create-stanje/magacioner-create-stanje.component';
import { AdminCreateSastavnicaComponent } from './admin-create-sastavnica/admin-create-sastavnica.component';
import {AdminCreateStavkaSastavnicaComponent} from './admin-create-stavka-sastavnica/admin-create-stavka-sastavnica.component';
import {AdminCreateTipSastavnicaComponent} from './admin-create-tip-sastavnica/admin-create-tip-sastavnica.component';
import {AdminCreatePodsastavnicaComponent} from './admin-create-podsastavnica/admin-create-podsastavnica.component';
import {AdminCreateSsTrebovanjeComponent} from './admin-create-ss-trebovanje/admin-create-ss-trebovanje.component';
import {AdminCreateStavkaMaterijalComponent} from './admin-create-stavka-materijal/admin-create-stavka-materijal.component';
import {AdminCreateStavkeVezaComponent} from './admin-create-stavke-veza/admin-create-stavke-veza.component';
import {AdminCreateSektorPogonaComponent} from './admin-create-sektor-pogona/admin-create-sektor-pogona.component';
import {AdminCreateTipMultipolaComponent} from './admin-create-tip-multipola/admin-create-tip-multipola.component';
import {OperaterChangeOsiguracComponent} from './operater-change-osigurac/operater-change-osigurac.component';
import {OperaterCreateTestComponent} from './operater-create-test/operater-create-test.component';
import {OperaterCreateKontrolaComponent} from './operater-create-kontrola/operater-create-kontrola.component';

const routes: Routes = [

  {
    path: '',
    component: LoginAgentComponent,
    children: [
    ]},
  {
    path: 'signup',
    component: RegistracionComponent,
    children: [
    ]},
  {
    path: 'noviRadniNalog',
    component: AdminCreateRadniNalogComponent,
    children: [
    ]},
  {
    path: 'novaStavkaRN',
    component: AdminCreateStavkaRnComponent,
    children: [
    ]},
  {
    path: 'novoStanje',
    component: MagacionerCreateStanjeComponent,
    children: [
    ]},
  {
    path: 'novaSastavnica',
    component: AdminCreateSastavnicaComponent,
    children: [
    ]},
  {
    path: 'novaStavkaSastavnice',
    component: AdminCreateStavkaSastavnicaComponent,
    children: [
    ]},
  {
    path: 'noviTipSastavnica',
    component: AdminCreateTipSastavnicaComponent,
    children: [
    ]},
  {
    path: 'novaPodsastavnica',
    component: AdminCreatePodsastavnicaComponent,
    children: [
    ]},
  {
    path: 'novoTrebovanjeSS',
    component: AdminCreateSsTrebovanjeComponent,
    children: [
    ]},
  {
    path: 'novoMaterijalSastavnica',
    component: AdminCreateStavkaMaterijalComponent,
    children: [
    ]},
  {
    path: 'novaStavkaVeza',
    component: AdminCreateStavkeVezaComponent,
    children: [
    ]},
  {
    path: 'noviSektorPogona',
    component: AdminCreateSektorPogonaComponent,
    children: [
    ]},
  {
    path: 'noviTipMultipola',
    component: AdminCreateTipMultipolaComponent,
    children: [
    ]},
  {
    path: 'izmenaOsiguraca',
    component: OperaterChangeOsiguracComponent,
    children: [
    ]},
  {
    path: 'noviTest',
    component: OperaterCreateTestComponent,
    children: [
    ]},
  {
    path: 'novaKontrola',
    component: OperaterCreateKontrolaComponent,
    children: [
    ]},
  {
    path: 'admin',
    component: AdminLayoutComponent,
    children: [
      {
        path: '',
        loadChildren: './admin-layout/admin-layout.module#AdminLayoutModule'
      }]
  },
  {
    path: 'magacioner',
    component: MagacionerLayoutComponent,
    children: [
      {
        path: '',
        loadChildren: './magacioner-layout/magacioner-layout.module#MagacionerLayoutModule'
      }]
  },
  {
    path: 'operater',
    component: OperaterLayoutComponent,
    children: [
      {
        path: '',
        loadChildren: './operater-layout/operater-layout.module#OperaterLayoutModule'
      }]
  },
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
  ],
})

export class AppRoutingModule { }
