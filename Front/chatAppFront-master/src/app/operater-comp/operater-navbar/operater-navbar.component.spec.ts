import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperaterNavbarComponent } from './operater-navbar.component';

describe('OperaterNavbarComponent', () => {
  let component: OperaterNavbarComponent;
  let fixture: ComponentFixture<OperaterNavbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperaterNavbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperaterNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
