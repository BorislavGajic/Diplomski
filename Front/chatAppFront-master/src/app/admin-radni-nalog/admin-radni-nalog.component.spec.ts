import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminRadniNalogComponent } from './admin-radni-nalog.component';

describe('AdminRadniNalogComponent', () => {
  let component: AdminRadniNalogComponent;
  let fixture: ComponentFixture<AdminRadniNalogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminRadniNalogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminRadniNalogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
