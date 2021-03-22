import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCreateSektorPogonaComponent } from './admin-create-sektor-pogona.component';

describe('AdminCreateSektorPogonaComponent', () => {
  let component: AdminCreateSektorPogonaComponent;
  let fixture: ComponentFixture<AdminCreateSektorPogonaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCreateSektorPogonaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCreateSektorPogonaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
