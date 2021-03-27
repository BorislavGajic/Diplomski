import {Routes} from '@angular/router';
import {ChatComponent} from '../chat/chat.component';
import {AdminProfilComponent} from '../admin-profil/admin-profil.component';
import {AdminKancelarijaComponent} from '../admin-kancelarija/admin-kancelarija.component';
import {AdminMagacinComponent} from '../admin-magacin/admin-magacin.component';
import {AdminPogonComponent} from '../admin-pogon/admin-pogon.component';
import {AdminRadniNalogComponent} from '../admin-radni-nalog/admin-radni-nalog.component';
import {AdminMaterijalComponent} from '../admin-materijal/admin-materijal.component';
import {AdminSastavnicaComponent} from '../admin-sastavnica/admin-sastavnica.component';
import {AdminSektorPogonaComponent} from '../admin-sektor-pogona/admin-sektor-pogona.component';
import {AdminTipOsiguracaComponent} from '../admin-tip-osiguraca/admin-tip-osiguraca.component';
import {AdminTipTestComponent} from '../admin-tip-test/admin-tip-test.component';
import {AdminTipKontrolaComponent} from '../admin-tip-kontrola/admin-tip-kontrola.component';

export const AdminLayoutRutes: Routes = [
  { path: 'chat',      component: ChatComponent },
  { path: 'profilAdmin',      component: AdminProfilComponent },
  { path: 'kancelarijeAdmin',      component: AdminKancelarijaComponent },
  { path: 'magaciniAdmin',      component: AdminMagacinComponent },
  { path: 'pogoniAdmin',      component: AdminPogonComponent },
  { path: 'radniNalogAdmin',      component: AdminRadniNalogComponent },
  { path: 'materijalAdmin',      component: AdminMaterijalComponent },
  { path: 'sastavnicaAdmin',      component: AdminSastavnicaComponent },
  { path: 'sektorPogonaAdmin',      component: AdminSektorPogonaComponent },
  { path: 'tipOsiguracaAdmin',      component: AdminTipOsiguracaComponent },
  { path: 'tipTestaAdmin',      component: AdminTipTestComponent },
  { path: 'tipKontrolaAdmin',      component: AdminTipKontrolaComponent }

];
