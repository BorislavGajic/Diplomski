import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MagacionerProfilComponent } from './magacioner-profil.component';

describe('MagacionerProfilComponent', () => {
  let component: MagacionerProfilComponent;
  let fixture: ComponentFixture<MagacionerProfilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MagacionerProfilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MagacionerProfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
