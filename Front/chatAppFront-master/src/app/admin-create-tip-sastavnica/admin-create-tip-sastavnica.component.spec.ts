import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCreateTipSastavnicaComponent } from './admin-create-tip-sastavnica.component';

describe('AdminCreateTipSastavnicaComponent', () => {
  let component: AdminCreateTipSastavnicaComponent;
  let fixture: ComponentFixture<AdminCreateTipSastavnicaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCreateTipSastavnicaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCreateTipSastavnicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
