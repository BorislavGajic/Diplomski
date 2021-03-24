import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperaterCreateTestComponent } from './operater-create-test.component';

describe('OperaterCreateTestComponent', () => {
  let component: OperaterCreateTestComponent;
  let fixture: ComponentFixture<OperaterCreateTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperaterCreateTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperaterCreateTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
