import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCreateStavkaMaterijalComponent } from './admin-create-stavka-materijal.component';

describe('AdminCreateStavkaMaterijalComponent', () => {
  let component: AdminCreateStavkaMaterijalComponent;
  let fixture: ComponentFixture<AdminCreateStavkaMaterijalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCreateStavkaMaterijalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCreateStavkaMaterijalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
