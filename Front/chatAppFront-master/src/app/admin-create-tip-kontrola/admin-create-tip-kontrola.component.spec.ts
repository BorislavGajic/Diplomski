import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCreateTipKontrolaComponent } from './admin-create-tip-kontrola.component';

describe('AdminCreateTipKontrolaComponent', () => {
  let component: AdminCreateTipKontrolaComponent;
  let fixture: ComponentFixture<AdminCreateTipKontrolaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCreateTipKontrolaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCreateTipKontrolaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
