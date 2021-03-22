import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperaterLayoutComponent } from './operater-layout.component';

describe('OperaterLayoutComponent', () => {
  let component: OperaterLayoutComponent;
  let fixture: ComponentFixture<OperaterLayoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperaterLayoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperaterLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
