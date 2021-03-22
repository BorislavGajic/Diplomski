import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminSastavnicaComponent } from './admin-sastavnica.component';

describe('AdminSastavnicaComponent', () => {
  let component: AdminSastavnicaComponent;
  let fixture: ComponentFixture<AdminSastavnicaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminSastavnicaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminSastavnicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
