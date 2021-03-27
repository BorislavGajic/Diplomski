import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCreateTipTestComponent } from './admin-create-tip-test.component';

describe('AdminCreateTipTestComponent', () => {
  let component: AdminCreateTipTestComponent;
  let fixture: ComponentFixture<AdminCreateTipTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCreateTipTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCreateTipTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
