import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperaterChangeOsiguracComponent } from './operater-change-osigurac.component';

describe('OperaterChangeOsiguracComponent', () => {
  let component: OperaterChangeOsiguracComponent;
  let fixture: ComponentFixture<OperaterChangeOsiguracComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperaterChangeOsiguracComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperaterChangeOsiguracComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
