import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCreateStavkeVezaComponent } from './admin-create-stavke-veza.component';

describe('AdminCreateStavkeVezaComponent', () => {
  let component: AdminCreateStavkeVezaComponent;
  let fixture: ComponentFixture<AdminCreateStavkeVezaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCreateStavkeVezaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCreateStavkeVezaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
