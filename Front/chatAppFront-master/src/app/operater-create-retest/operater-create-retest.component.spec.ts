import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperaterCreateRetestComponent } from './operater-create-retest.component';

describe('OperaterCreateRetestComponent', () => {
  let component: OperaterCreateRetestComponent;
  let fixture: ComponentFixture<OperaterCreateRetestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperaterCreateRetestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperaterCreateRetestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
