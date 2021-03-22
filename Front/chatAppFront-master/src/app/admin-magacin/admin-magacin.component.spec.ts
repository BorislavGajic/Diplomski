import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminMagacinComponent } from './admin-magacin.component';

describe('AdminMagacinComponent', () => {
  let component: AdminMagacinComponent;
  let fixture: ComponentFixture<AdminMagacinComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminMagacinComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminMagacinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
