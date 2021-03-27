import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminTipTestComponent } from './admin-tip-test.component';

describe('AdminTipTestComponent', () => {
  let component: AdminTipTestComponent;
  let fixture: ComponentFixture<AdminTipTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminTipTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminTipTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
