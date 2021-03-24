import {Routes} from '@angular/router';
import {ChatComponent} from '../chat/chat.component';
import {OperaterProfilComponent} from '../operater-profil/operater-profil.component';
import {OperaterOsiguracComponent} from '../operater-osigurac/operater-osigurac.component';
import {OperaterRadniNalogComponent} from '../operater-radni-nalog/operater-radni-nalog.component';
import {OperaterTestComponent} from '../operater-test/operater-test.component';
import {OperaterTomComponent} from '../operater-tom/operater-tom.component';
import {OperaterKontrolaComponent} from '../operater-kontrola/operater-kontrola.component';

export const OperaterLayoutRutes: Routes = [
  { path: 'chat',      component: ChatComponent },
  { path: 'operaterProfil',      component: OperaterProfilComponent },
  { path: 'operaterOsigurac',      component: OperaterOsiguracComponent },
  { path: 'operaterRadniNalog',      component: OperaterRadniNalogComponent },
  { path: 'operaterTest',      component: OperaterTestComponent },
  { path: 'operaterTOM',      component: OperaterTomComponent },
  { path: 'operaterKontrola',      component: OperaterKontrolaComponent },
];
