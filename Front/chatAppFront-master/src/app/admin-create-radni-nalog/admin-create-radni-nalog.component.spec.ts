import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCreateRadniNalogComponent } from './admin-create-radni-nalog.component';

describe('AdminCreateRadniNalogComponent', () => {
  let component: AdminCreateRadniNalogComponent;
  let fixture: ComponentFixture<AdminCreateRadniNalogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCreateRadniNalogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCreateRadniNalogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
