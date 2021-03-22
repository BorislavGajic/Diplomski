import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminKancelarijaComponent } from './admin-kancelarija.component';

describe('AdminKancelarijaComponent', () => {
  let component: AdminKancelarijaComponent;
  let fixture: ComponentFixture<AdminKancelarijaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminKancelarijaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminKancelarijaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
