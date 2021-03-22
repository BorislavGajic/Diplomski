import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MagacionerNavbarComponent } from './magacioner-navbar.component';

describe('MagacionerNavbarComponent', () => {
  let component: MagacionerNavbarComponent;
  let fixture: ComponentFixture<MagacionerNavbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MagacionerNavbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MagacionerNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
