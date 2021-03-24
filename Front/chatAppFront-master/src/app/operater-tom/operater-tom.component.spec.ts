import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperaterTomComponent } from './operater-tom.component';

describe('OperaterTomComponent', () => {
  let component: OperaterTomComponent;
  let fixture: ComponentFixture<OperaterTomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperaterTomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperaterTomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
