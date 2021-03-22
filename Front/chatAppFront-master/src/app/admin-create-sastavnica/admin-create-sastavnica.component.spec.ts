import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCreateSastavnicaComponent } from './admin-create-sastavnica.component';

describe('AdminCreateSastavnicaComponent', () => {
  let component: AdminCreateSastavnicaComponent;
  let fixture: ComponentFixture<AdminCreateSastavnicaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCreateSastavnicaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCreateSastavnicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
