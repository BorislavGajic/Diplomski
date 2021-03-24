import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperaterTestComponent } from './operater-test.component';

describe('OperaterTestComponent', () => {
  let component: OperaterTestComponent;
  let fixture: ComponentFixture<OperaterTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperaterTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperaterTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
