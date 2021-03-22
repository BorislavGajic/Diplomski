import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCreateSsTrebovanjeComponent } from './admin-create-ss-trebovanje.component';

describe('AdminCreateSsTrebovanjeComponent', () => {
  let component: AdminCreateSsTrebovanjeComponent;
  let fixture: ComponentFixture<AdminCreateSsTrebovanjeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCreateSsTrebovanjeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCreateSsTrebovanjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
