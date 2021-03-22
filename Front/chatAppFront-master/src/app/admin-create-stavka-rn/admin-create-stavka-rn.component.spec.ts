import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCreateStavkaRnComponent } from './admin-create-stavka-rn.component';

describe('AdminCreateStavkaRnComponent', () => {
  let component: AdminCreateStavkaRnComponent;
  let fixture: ComponentFixture<AdminCreateStavkaRnComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCreateStavkaRnComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCreateStavkaRnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
