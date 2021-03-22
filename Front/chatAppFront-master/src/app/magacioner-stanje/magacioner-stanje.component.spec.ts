import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MagacionerStanjeComponent } from './magacioner-stanje.component';

describe('MagacionerStanjeComponent', () => {
  let component: MagacionerStanjeComponent;
  let fixture: ComponentFixture<MagacionerStanjeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MagacionerStanjeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MagacionerStanjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
