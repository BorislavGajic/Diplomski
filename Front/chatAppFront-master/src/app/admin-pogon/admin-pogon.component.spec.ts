import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminPogonComponent } from './admin-pogon.component';

describe('AdminPogonComponent', () => {
  let component: AdminPogonComponent;
  let fixture: ComponentFixture<AdminPogonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminPogonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminPogonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
