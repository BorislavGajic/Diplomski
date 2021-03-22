import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminMaterijalComponent } from './admin-materijal.component';

describe('AdminMaterijalComponent', () => {
  let component: AdminMaterijalComponent;
  let fixture: ComponentFixture<AdminMaterijalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminMaterijalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminMaterijalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
