import {Routes} from '@angular/router';
import {ChatComponent} from '../chat/chat.component';
import {OperaterProfilComponent} from '../operater-profil/operater-profil.component';
import {OperaterOsiguracComponent} from '../operater-osigurac/operater-osigurac.component';

export const OperaterLayoutRutes: Routes = [
  { path: 'chat',      component: ChatComponent },
  { path: 'operaterProfil',      component: OperaterProfilComponent },
  { path: 'operaterOsigurac',      component: OperaterOsiguracComponent },
];
