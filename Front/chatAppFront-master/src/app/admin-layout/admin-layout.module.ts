import { NgModule } from '@angular/core'; //
import { CommonModule } from '@angular/common'; //
import { AdminLayoutComponent } from './admin-layout.component'; //
import {RouterModule} from '@angular/router'; //
import {FormsModule, ReactiveFormsModule} from '@angular/forms'; //
import {NgbModule} from '@ng-bootstrap/ng-bootstrap'; //
import {FlatpickrModule} from 'angularx-flatpickr'; //
import {AdminCompModule} from '../admin-comp/admin-comp.module'; //
import {AdminLayoutRutes} from './admin-layout.routing';
import {AdminProfilComponent} from '../admin-profil/admin-profil.component';
import {ChatComponent} from '../chat/chat.component';
import {AdminKancelarijaComponent} from '../admin-kancelarija/admin-kancelarija.component';
import {AdminMagacinComponent} from '../admin-magacin/admin-magacin.component';
import {AdminPogonComponent} from '../admin-pogon/admin-pogon.component';
import {AdminRadniNalogComponent} from '../admin-radni-nalog/admin-radni-nalog.component';
import {MatFormFieldModule, MatSelectModule} from '@angular/material';
import {AdminMaterijalComponent} from '../admin-materijal/admin-materijal.component';
import {AdminSastavnicaComponent} from '../admin-sastavnica/admin-sastavnica.component';
import {AdminSektorPogonaComponent} from '../admin-sektor-pogona/admin-sektor-pogona.component';
import {AdminTipOsiguracaComponent} from '../admin-tip-osiguraca/admin-tip-osiguraca.component';



@NgModule({
  declarations: [AdminLayoutComponent,
    ChatComponent,
    AdminProfilComponent,
    AdminKancelarijaComponent,
    AdminMagacinComponent,
    AdminPogonComponent,
    AdminRadniNalogComponent,
    AdminMaterijalComponent,
    AdminSastavnicaComponent,
    AdminSektorPogonaComponent,
    AdminTipOsiguracaComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRutes),
    FormsModule,
    NgbModule,
    ReactiveFormsModule,
    FlatpickrModule.forRoot(),
    AdminCompModule,
    MatFormFieldModule,
    MatSelectModule
  ],
  exports: [AdminLayoutComponent
  ]
})
export class AdminLayoutModule { }
