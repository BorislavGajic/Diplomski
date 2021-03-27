import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperaterCreateRekonComponent } from './operater-create-rekon.component';

describe('OperaterCreateRekonComponent', () => {
  let component: OperaterCreateRekonComponent;
  let fixture: ComponentFixture<OperaterCreateRekonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperaterCreateRekonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperaterCreateRekonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
