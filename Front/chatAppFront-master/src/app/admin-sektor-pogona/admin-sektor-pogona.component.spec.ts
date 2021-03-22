import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminSektorPogonaComponent } from './admin-sektor-pogona.component';

describe('AdminSektorPogonaComponent', () => {
  let component: AdminSektorPogonaComponent;
  let fixture: ComponentFixture<AdminSektorPogonaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminSektorPogonaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminSektorPogonaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
