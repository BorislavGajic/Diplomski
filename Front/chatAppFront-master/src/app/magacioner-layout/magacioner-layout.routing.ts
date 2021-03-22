import {Routes} from '@angular/router';
import {ChatComponent} from '../chat/chat.component';
import {AdminProfilComponent} from '../admin-profil/admin-profil.component';
import {MagacionerStanjeComponent} from '../magacioner-stanje/magacioner-stanje.component';

export const MagacionerLayoutRutes: Routes = [
  { path: 'chat',      component: ChatComponent },
  { path: 'magacionerProfil',      component: AdminProfilComponent },
  { path: 'magacionerStanje',      component: MagacionerStanjeComponent },

];
