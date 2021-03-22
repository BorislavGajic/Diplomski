import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCreateStavkaSastavnicaComponent } from './admin-create-stavka-sastavnica.component';

describe('AdminCreateStavkaSastavnicaComponent', () => {
  let component: AdminCreateStavkaSastavnicaComponent;
  let fixture: ComponentFixture<AdminCreateStavkaSastavnicaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCreateStavkaSastavnicaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCreateStavkaSastavnicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
