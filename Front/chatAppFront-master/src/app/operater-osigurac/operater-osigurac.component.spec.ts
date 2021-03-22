import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperaterOsiguracComponent } from './operater-osigurac.component';

describe('OperaterOsiguracComponent', () => {
  let component: OperaterOsiguracComponent;
  let fixture: ComponentFixture<OperaterOsiguracComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperaterOsiguracComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperaterOsiguracComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
