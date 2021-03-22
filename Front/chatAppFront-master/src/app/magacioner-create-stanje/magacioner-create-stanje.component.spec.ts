import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MagacionerCreateStanjeComponent } from './magacioner-create-stanje.component';

describe('MagacionerCreateStanjeComponent', () => {
  let component: MagacionerCreateStanjeComponent;
  let fixture: ComponentFixture<MagacionerCreateStanjeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MagacionerCreateStanjeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MagacionerCreateStanjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
