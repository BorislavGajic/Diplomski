import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperaterKontrolaComponent } from './operater-kontrola.component';

describe('OperaterKontrolaComponent', () => {
  let component: OperaterKontrolaComponent;
  let fixture: ComponentFixture<OperaterKontrolaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperaterKontrolaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperaterKontrolaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
