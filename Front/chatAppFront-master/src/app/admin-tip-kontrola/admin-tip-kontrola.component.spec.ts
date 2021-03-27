import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminTipKontrolaComponent } from './admin-tip-kontrola.component';

describe('AdminTipKontrolaComponent', () => {
  let component: AdminTipKontrolaComponent;
  let fixture: ComponentFixture<AdminTipKontrolaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminTipKontrolaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminTipKontrolaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
